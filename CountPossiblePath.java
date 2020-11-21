package graph;

import java.util.*;

public class CountPossiblePath {


    public static void main(String args[]) {


        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1,2,3));
        graph.put(2, Arrays.asList(0,1));
        graph.put(1, Arrays.asList(3));
        int source = 2;
        int dest = 3;
        CountPossiblePath p = new CountPossiblePath();
        List<List<Integer>> paths = new ArrayList<>();
        System.out.println(p.countPath(graph,source,dest,paths));
        System.out.println(paths);



    }

    public int countPath(Map<Integer, List<Integer>> graph, int s ,int d, List<List<Integer>> paths){
        int pathCount = 0;
        Set<Integer> visited = new HashSet<>();

        return countPathUtils(pathCount,graph,s,d,visited,paths);

    }

    public int countPathUtils(int pathCount, Map<Integer, List<Integer>> graph, int s, int d,
                              Set<Integer> visited,List<List<Integer>> paths) {

        visited.add(s);

        if(s == d){
            pathCount++;
            paths.add(new ArrayList<>(visited));
        //    System.out.println("Path is "+visited);
        } else{
            List<Integer> neighbour = graph.get(s);
            //if(neighbour != null) {
            for (int c : neighbour) {

                if (!visited.contains(c)) {
                    pathCount = countPathUtils(pathCount, graph, c, d, visited,paths);
                }
            }
            // }
        }



        visited.remove(s);
        return pathCount;

    }
}
