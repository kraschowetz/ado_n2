import java.util.ArrayList;
import java.util.List;

public class No <T>{
    private T valor;
    private List<Aresta<T>> arestas;

    public No(T valor) {
        this.valor = valor;
        this.arestas = new ArrayList<>();
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public List<Aresta<T>> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta<T>> arestas) {
        this.arestas = arestas;
    }    

    public void adicionaAresta(Aresta<T> aresta) {
        this.arestas.add(aresta);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("['");
        b.append(valor);
        b.append("']");
        b.append(" {\n");
        
        for(Aresta<T> a : arestas) {
            b.append("\t");
            b.append(a.distancia);
            b.append("m -> ");
            b.append(a.fim.valor);
            b.append("\n");
        }
        b.append("}");

        return b.toString();
    }

}
