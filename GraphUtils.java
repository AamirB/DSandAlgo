package graph;

import java.util.*;

public class GraphUtils {




    public static void main(String args[]) {
        topologicalSort(getDefaultGraphForTopoDependecies());
    }

    public static Map<Integer, LinkedList<Integer>> buildRelationsShip
            (List<Integer> primesBetweenSourceAndDestinations, boolean isUndirected) {

        Map<Integer,LinkedList<Integer>> graph = new HashMap<>();

        for(int i = 0; i < primesBetweenSourceAndDestinations.size()-1; i++) {

            int source =  primesBetweenSourceAndDestinations.get(i);


            for(int j = i+1; j< primesBetweenSourceAndDestinations.size(); j++) {
                int destinations =  primesBetweenSourceAndDestinations.get(j);
                addEdge(graph, source, destinations);
                if(isUndirected){
                    addEdge(graph, destinations, source);
                }

            }
        }
        return graph;
    }

    private static void addEdge(Map<Integer,LinkedList<Integer>> graph, int source, int destinations) {
        if(graph.get(source) == null){
            graph.put(source, new LinkedList<>());
        }
        graph.get(source).addLast(destinations);
    }


    public static Map<Integer,LinkedList<Integer>> getDefaultGraph() {

        Map<Integer,LinkedList<Integer>> graph = new HashMap<>();

        graph.put(0,  new LinkedList<Integer>());
        graph.put(1,  new LinkedList<Integer>());
        graph.put(2,  new LinkedList<Integer>());
        graph.put(3,  new LinkedList<Integer>());
        graph.put(4,  new LinkedList<Integer>());
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 4);
        return graph;

    }

    public static Map<Integer,LinkedList<Integer>> getCyclicGraph() {

        Map<Integer,LinkedList<Integer>> graph = new HashMap<>();

        graph.put(0,  new LinkedList<Integer>());
        graph.put(1,  new LinkedList<Integer>());
        graph.put(2,  new LinkedList<Integer>());
        graph.put(3,  new LinkedList<Integer>());
        graph.put(4,  new LinkedList<Integer>());
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 4);
        addEdge(graph, 4, 2);
        return graph;

    }

    public static Map<Integer,LinkedList<Integer>> getDefaultGraphForTopoDependecies() {

        Map<Integer,LinkedList<Integer>> graph = new HashMap<>();

        graph.put(5,  new LinkedList<Integer>());
        graph.put(4,  new LinkedList<Integer>());
        graph.put(2,  new LinkedList<Integer>());
        graph.put(3,  new LinkedList<Integer>());
        graph.put(0,  new LinkedList<Integer>());
        graph.put(1,  new LinkedList<Integer>());
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 0);
        addEdge(graph, 4, 0);
        addEdge(graph, 4, 1);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);
        return graph;

    }


    public static int shortestDistance(Map<Integer,LinkedList<Integer>> graph, int source, int d) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        Map<Integer,Integer> distanceFromSource = new HashMap<>();
        distanceFromSource.put(source,0);
        while(!queue.isEmpty()) {

            int top = queue.poll();
            if (top == d) {
                System.out.println("Shortest distance is " + distanceFromSource.get(d));
                return distanceFromSource.get(d);
            }
            for (int child : graph.get(top)) {

                if (distanceFromSource.get(child) == null) {
                    queue.add(child);
                    distanceFromSource.put(child, distanceFromSource.get(top) + 1);
                }

            }
        }
        System.out.println("Source and Destinations not reachable .. ");
        return -1;
    }

    public static int shortestDistance(LinkedList<Integer> graph[], int source, int d) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        Map<Integer,Integer> distanceFromSource = new HashMap<>();
        distanceFromSource.put(source,0);
        while(!queue.isEmpty()) {

            int top = queue.poll();
            if (top == d) {
                System.out.println("Shortest distance is " + distanceFromSource.get(d));
                return distanceFromSource.get(d);
            }
            for (int child : graph[top]) {

                if (distanceFromSource.get(child) == null) {
                    queue.add(child);
                    distanceFromSource.put(child, distanceFromSource.get(top) + 1);
                }

            }
        }
        System.out.println("Source and Destinations not reachable .. ");
        return -1;
    }


    public static void topologicalSort(Map<Integer,LinkedList<Integer>> graph) {

        Set<Integer> visited = new HashSet<>();

        Stack<Integer> results = new Stack<>();

        for(Integer k : graph.keySet()) {

            if(!visited.contains(k)) {
                tSort(results,visited,graph,k);
            }
        }


        System.out.println("Topological Sort is ...");

        while(!results.isEmpty()) {
            System.out.print( results.pop() + " ");
        }


    }






    private static void tSort(Stack<Integer> results,Set<Integer>  visited,
                              Map<Integer,LinkedList<Integer>>graph, int k) {

        visited.add(k);
        for(Integer ch: graph.get(k)) {
            if(!visited.contains(ch)) {

                tSort(results,visited,graph,ch);
            }
        }

        results.push(k);

    }
}
