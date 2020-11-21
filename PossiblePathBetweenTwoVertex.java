package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PossiblePathBetweenTwoVertex {
    static Map<Integer, LinkedList<Integer>> graph;

    public static void main(String args[]){
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> totalPath = new ArrayList<>();
        graph =  GraphUtils.getDefaultGraph();
        int source = 0;
        int dest = 3;
        getPathBetweenVertex(totalPath, currentPath, source, dest, new HashSet<>());
        System.out.println(totalPath);
    }


    public static void getPathBetweenVertex(List<List<Integer>> totalPath, List<Integer> currentPath,
                                     int source, int dest, Set<Integer> visited){
       // if(!visited.contains(source)){

        //}

        if(source == dest){
            currentPath.add(source);
            totalPath.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size()-1);
            return;
        }

        for(int child : graph.get(source)) {
                    if(visited.contains(child)){
                        continue;
                    }
            currentPath.add(source);
            getPathBetweenVertex(totalPath, currentPath, child, dest, visited);
            currentPath.remove(currentPath.size()-1);
                   //visited.remove(child);
                }




                }





}
