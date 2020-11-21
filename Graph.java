package google.graph;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

    private List<Edge<T>> allEdges;

    private Map<Vertex<T>,List<Edge<T>>> vertexToEdge ;

    public Graph(){

        allEdges = new ArrayList<>();
        vertexToEdge = new HashMap();

    }

    public void addEdge(Vertex<T> source, Vertex<T> dest, T weight) {

        Edge e = new Edge(source, dest, weight);
        allEdges.add(e);

        source.getAdjacentVertex().add(dest);
        vertexToEdge.putIfAbsent(source, new ArrayList<>());
        vertexToEdge.get(source).add(e);

        dest.getAdjacentVertex().add(source);
        vertexToEdge.putIfAbsent(dest, new ArrayList<>());
        vertexToEdge.get(dest).add(e);
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }


    public Set<Vertex<T>> getAllVertex(){
       return vertexToEdge.keySet();
    }

    public class EdgeComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
            if (edge1.getWeight() <= edge2.getWeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    }





}
