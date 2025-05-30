import java.util.ArrayList;

public class Grafo <T> {
    private ArrayList<No<T>> nos;

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

    public No<T> getNo(T valor) {
        for(No<T> n : nos) {
            if(n.getValor().equals(valor)) {
                return n;
            }
        }
        return null;
    }
}