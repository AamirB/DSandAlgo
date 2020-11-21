package google.graph;


//https://leetcode.com/discuss/interview-question/125162/Google-or-Onsite-or-Longest-Consecutive-Sequence-in-Graph
//DFS+ memoization while only visiting neighbors with difference 1. DFS over all nodes.
// Memoization brings down time complexity to O(E+V) with O(V) space complexity.


// second approach
// Traverse the graph source and for each negihbour check the diff 1 for neighbour and union
//final ans wiil have the
// just return the largest difference between a node and it’s absolute root parent. and print it
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConSecutiveSequence {


    Map<Integer, List<Integer>> graph = new HashMap<>();

    int[] mem ;


    public void lcs(int[][] edges){


        int n = 10;
        mem = new int[n+1];
        Arrays.fill(mem, -1);
        for(int[] e :edges){

            int source = e[0];
            int dest = e[1];

            graph.putIfAbsent(source, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }

        for(int j=1;j<n+1;j++){
            int c = dfs(j);
        }

    }


    public int dfs(int i){

        if(mem[i] != -1)
            return mem[i];

        int c = 1;

        for(int neighbour : graph.get(i)){

            if(i+1 != neighbour){
                continue;
            }
            c= c+ dfs(neighbour);


        }
        mem[i]= c;
        return mem[i];


    }


}
