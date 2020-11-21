package google.graph;

//https://leetcode.com/discuss/interview-question/305644/Google-or-Onsite-or-Triangles-in-graph

// find mappring for point a and find mapping for point b. Intersection between a and B will be count of triange


//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/NumberofTriangles.java

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TriangleInGraph {


    public static void main(String args[]){
        int n = 6;
        int[][] edges = {{0,1}, {3,0}, {0,2}, {3,2}, {1,2}, {4,0}, {3,4}, {3,5}, {4,5}, {1,5}, {1,3}};

        Map<Integer, Set<Integer>> vertexMapping = new HashMap<>();

        for(int[] edge : edges){

            int x = edge[0];
            int y = edge[1];

            vertexMapping.putIfAbsent(x, new HashSet<>());
            vertexMapping.get(x).add(y);

            // undirected edges
            vertexMapping.putIfAbsent(y, new HashSet<>());
            vertexMapping.get(y).add(x);
        }

        // find intersection for each points count

        int res = 0;
        for(int i=0;i<vertexMapping.size();i++){

            for(int j=i+1; j<vertexMapping.size()-1;j++){

                int total = vertexMapping.get(i).size() + vertexMapping.get(j).size();
                Set<Integer> sets = new HashSet<>();
                sets.addAll(vertexMapping.get(i));
                sets.addAll(vertexMapping.get(j));
                int common = total - sets.size();
                res = res + common;
            }
        }

        // note this common will be for all 3 points so need to be divide by 3;

        System.out.println("Result ..."+ res/3);


    }
}
