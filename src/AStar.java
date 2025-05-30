import java.util.ArrayList;
import java.util.List;

public class AStar <T> {

    private void deployHcostCalc(No<T> no, int hcost) {
        if(no.hcost >= 0 && hcost >= no.hcost) {
            return;
        }
        no.hcost = hcost;
        
        for(Aresta<T> a : no.getArestas()) {
            deployHcostCalc(a.fim, hcost + a.distancia);
        }
    }

    public void calcHCost(No<T> fim) {
        deployHcostCalc(fim, 0);
    }

    public List<No<T>> calcPath(No<T> inicio, No<T> fim) {
        calcHCost(fim);
        List<No<T>> caminho = new ArrayList<>();

        caminho.add(inicio);

        if(inicio == fim) {
            return caminho;
        }
        
        No<T> atual = inicio;
        int gcost = 0;
        while(atual != fim) {
            int menorFcost = Integer.MAX_VALUE;
            int melhorGcost = 0;
            No<T> melhorNo = null;
            for(int i = 0; i < atual.getArestas().size(); i++) {
                var a = atual.getArestas().get(i);
                int fcost = a.distancia + gcost + a.fim.hcost;
                if (fcost < menorFcost) {
                    menorFcost = fcost;
                    melhorNo = a.fim;
                    melhorGcost = a.distancia;
                }
            }
            gcost += melhorGcost;
            atual = melhorNo;
            caminho.add(atual);
        }

        return caminho;
    }
}
