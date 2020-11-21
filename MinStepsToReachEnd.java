package graph;

import java.util.*;

public class MinStepsToReachEnd {

    public static void main(String args[]) {
        int arr[] = {5, 4, 2, 5, 0};
        MinStepsToReachEnd stepsToReachEnd = new MinStepsToReachEnd();

        LinkedList<Integer> g[] = stepsToReachEnd.buildGraph(arr);
        System.out.println(GraphUtils.shortestDistance(g, 0, arr.length-1));


    }


    public LinkedList<Integer>[] buildGraph(int arr[]) {
        LinkedList<Integer> g[] = new LinkedList[10];
        Map<Integer,LinkedList<Integer>> numToIndex = findIndex(arr);
        for(int i=0;i<arr.length;i++) {
            g[arr[i]] = new LinkedList<>();
        }

        if(arr.length  > 1 ) {
            g[0].add(1);
            for(int ch : numToIndex.get(arr[0])){
                if(ch != 0){
                    g[0].add(ch);
                }

            }
        }
        int i;
        for( i=1; i< arr.length-1;i++) {
            g[i].add(i+1);
            g[i].add(i-1);
            for(int ch : numToIndex.get(arr[i])){
                if( i != ch){
                    g[i].add(ch);
                }

            }
        }
        if(i == arr.length - 1 ) {
            g[i].add(i-1);
            for(int ch : numToIndex.get(arr[i])){
                if( i != ch){
                    g[i].add(ch);
                }

            }
        }
        return g;
    }


    private Map<Integer,LinkedList<Integer>> findIndex(int[] arr) {
        Map<Integer,LinkedList<Integer>> index = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(index.get(arr[i])==null){
                index.put(arr[i], new LinkedList<>());
            }
            index.get(arr[i]).add(i);

        }
        return index;
    }



}
