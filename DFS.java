package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS {


    public static void main(String args[]){

        Map<Integer, LinkedList<Integer>> graph =  GraphUtils.getCyclicGraph();
        DFS dfs = new DFS();
        dfs.dfsTraverse(graph, new HashSet<>(), 2);
        dfs.dfsIterative(graph, 2);
//        System.out.println(dfs.isCyclic(graph,2));
//        System.out.println(dfs.isCyclic(GraphUtils.getCyclicGraph(),2));

    }


    public void dfsTraverse(Map<Integer, LinkedList<Integer>> graph, Set<Integer> visited, Integer node ) {

        System.out.println(node + " ");
        visited.add(node);

        for(Integer s : graph.get(node)){

            if(visited.contains(s)){
                continue;
            }

            visited.add(node);
            dfsTraverse(graph, visited, s);

        }


    }


    public void dfsIterative(Map<Integer, LinkedList<Integer>> graph, Integer source){

        System.out.println( " dfsIterative ");
        Stack<Integer> stack = new Stack();
        Set<Integer> visited = new HashSet<>();
        stack.push(source);
        visited.add(source);

        while(!stack.isEmpty()) {

            Integer node = stack.pop();
            System.out.print (node + " ");

            for(Integer child: graph.get(node)){

                if(!visited.contains(child)){
                    stack.push(child);
                    visited.add(child);
                }
            }
        }
    }
}
