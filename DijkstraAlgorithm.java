package graph;

import java.util.*;

public class DijkstraAlgorithm {

    private static int Vertex = 9;

    public static void main(String args[]) {
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        DijkstraAlgorithm d = new DijkstraAlgorithm();
        d.shortestPath(graph,0);


        System.out.println();
    }


    public void shortestPath(int graph[][], int source) {

        int dist[] = new int[Vertex];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        boolean processed[] = new boolean[Vertex];
        //processed[source] = true;

        for(int count = 0; count<Vertex;count++){

            int u = findMinDistance(dist, processed);
            processed[u] = true;

            for(int v=0;v<Vertex;v++) {

                if(!processed[v] && graph[u][v] !=0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }

            }



        }

        printSolution(dist);
    }


    public void shortestPathAdjacency(Map<Integer,List<Integer>> graph, int source) {
        Map<Integer, Integer> vertexToDistance = new HashMap<>();
        Map<Integer, Integer> processedVertexDistance = new HashMap<>();
        Map<Integer, Integer> parentToVertex = new HashMap<>();






    }

    private int findMinDistance(int dist[], boolean processed[]){

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i=0;i<Vertex;i++) {

            if(!processed[i] && dist[i]< min){
                min = dist[i];
                minIndex = i;
            }

        }
        return minIndex;

    }







    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < Vertex; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
