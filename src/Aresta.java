public class Aresta <T> {
    No<T> fim;
    int distancia;

    public Aresta(No<T> fim, int distancia) {
        this.fim = fim;
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Aresta [fim=" + fim + ", distancia=" + distancia + "]";
    }

}
