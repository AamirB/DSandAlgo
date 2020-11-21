package google.graph;

import java.util.ArrayList;
import java.util.List;


public class Vertex<T> {

    private T data;

    private List<Vertex<T>> adjacentVertex;

    public T getData() {
        return data;
    }

    Vertex(T d){
        this.data = d;
        adjacentVertex = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +

                '}';
    }

    public List<Vertex<T>> getAdjacentVertex(){
        return adjacentVertex;
    }

}