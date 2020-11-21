package graph;

import java.util.*;

public class BFS {


    public static void main(String args[]) {
        BFS bfs = new BFS();
        //bfs.bfSearch(GraphUtils.getDefaultGraph(),2);
        System.out.println(GraphUtils.shortestDistance(GraphUtils.getDefaultGraph(), 2,1));
    }


    public void bfSearch(Map<Integer, LinkedList<Integer>> graph , int source) {

        System.out.println("Path in graph is ");
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        while(!queue.isEmpty()) {

            int top = queue.poll();
            System.out.println(top);

            for(int child:graph.get(top)) {

                if(!visited.contains(child)) {
                    queue.add(child);
                    visited.add(child);
                }

            }
        }
    }
}
