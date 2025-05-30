import java.util.ArrayList;
import java.util.List;

public class Grafo <T> {
    private List<No<T>> nos;

    public void adicionaVertice(T vertice) {
        nos.add(new No<>(vertice));
    }

    public void adicionaAresta(int distancia, T inicio, T fim) {
        No<T> noInicio = null, noFim = null;

        for(No<T> n : nos) {
            if(n.getValor() == inicio)
                noInicio = n;
            if(n.getValor() == fim)
                noFim = n;
        }

        noInicio.adicionaAresta(
            new Aresta<T>(noFim, distancia)
        );
    }

    public Grafo() {
        nos = new ArrayList<>();
    }

    public void printGrafo() {
        for(No<T> n : nos) {
            System.out.println(n);
        }
    }
}