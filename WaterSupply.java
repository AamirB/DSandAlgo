package google.graph;


//https://leetcode.com/discuss/interview-question/265623/Google-or-Phone-screen-or-Water-supply

//https://leetcode.com/discuss/interview-question/321507/Google-or-Onsite-interview-or-Power-supply
// min cost to build water supply in all the house

// chack the graph representations

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

//basically find the MST
// Using Krushkal Algorithm using Disjoint set
public class WaterSupply {



    public static void main(String args[]){

        Graph graph = new Graph();
        Vertex<Integer> vertex0 = new Vertex<>(0);
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);

        graph.addEdge(vertex0,vertex1,5);
        graph.addEdge(vertex0,vertex4,100);
        graph.addEdge(vertex1,vertex4,20);
        graph.addEdge(vertex1,vertex3,70);
        graph.addEdge(vertex2,vertex3,9);
        graph.addEdge(vertex4,vertex2,17);

        System.out.println(" Before Comparator " + graph.getAllEdges());

        List<Edge<Integer>> allEdges = graph.getAllEdges();

        Collections.sort(allEdges, new EdgeComparator());
        System.out.println(" After Comparator " + graph.getAllEdges());

        printKrushkalMST(graph);
    }


    public static class EdgeComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
            if (edge1.getWeight() <= edge2.getWeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    }


    public static void printKrushkalMST(Graph graph) {

        List<Edge<Integer>> edges = graph.getAllEdges();
        Collections.sort(edges, new EdgeComparator());
        Set<Vertex<Integer>> vertex = graph.getAllVertex();

        DisJointSet disJointSet = new DisJointSet();

        for(Vertex<Integer> v : vertex){
            disJointSet.makeSet(v.getData());
        }
        List<Edge<Integer>> resultEdge = new ArrayList<>();
        for(Edge<Integer> edge : edges){

            DisJointSet.Node p1 = disJointSet.findSet(edge.getVertex1().getData());

            DisJointSet.Node p2 = disJointSet.findSet(edge.getVertex2().getData());

            if(p1 == p2){
                continue;
            } else {
                resultEdge.add(edge);
                disJointSet.union(edge.getVertex1().getData(), edge.getVertex2().getData());
            }
        }

        System.out.println("Result MST...");
      //  System.out.println(resultEdge);
        int cost = 0;

        for(Edge<Integer> edge : resultEdge){
            cost = cost + edge.getWeight();
        }

        System.out.println("Result COST..."+ cost);

    }


}
