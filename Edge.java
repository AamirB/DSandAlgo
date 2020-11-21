package google.graph;



public class Edge<T> {

    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private T weight;

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public T getWeight() {
        return weight;
    }

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2, T weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                '}';
    }
}