package graph;


//https://www.geeksforgeeks.org/shortest-path-reach-one-prime-changing-single-digit-time/

import java.util.*;
import java.util.stream.Collectors;

public class ShortestPathBetweenTwoPrimes {


    public static void main(String args[]) {
        int s1 = 8017;
        int s2 = 8179;
        ShortestPathBetweenTwoPrimes shortestPrimes = new ShortestPathBetweenTwoPrimes();
        List<Integer>  primesBetweenSourceAndDestinations = shortestPrimes.getPrimeBetWeenRange(s1,s2);
        Map<Integer,LinkedList<Integer>> graph =
                shortestPrimes.buildRelationsShip(primesBetweenSourceAndDestinations);
        System.out.println(shortestPrimes.findShortestpath(s1, s2, graph));
    }

    private List<Integer> getPrimeBetWeenRange(int s1, int s2) {
        Set<Integer> primesNumbers = new HashSet<>();
        int isPrime[] = new int[s2+1];
        Arrays.fill(isPrime,1);

        for(int i=2;i*i<=s2;i++) {

            if(isPrime[i]==1) {
                for(int j=i*i;j<=s2;j=j+i) {
                    isPrime[j] = 0;
                }
            }
        }
        for(int s = s1; s < isPrime.length; s++) {
            if(isPrime[s] == 1) {
                primesNumbers.add(s);
            }
        }
        return primesNumbers.stream().collect(Collectors.toList());
      }

    private Map<Integer,LinkedList<Integer>> buildRelationsShip
            (List<Integer>  primesBetweenSourceAndDestinations) {

        Map<Integer,LinkedList<Integer>> graph = new HashMap<>();

        for(int i = 0; i < primesBetweenSourceAndDestinations.size()-1; i++) {

            int source =  primesBetweenSourceAndDestinations.get(i);


            for(int j = i+1; j< primesBetweenSourceAndDestinations.size(); j++) {
                int destinations =  primesBetweenSourceAndDestinations.get(j);

                if(isOneDigitDifference(source,destinations)){
                    addEdge(graph, source, destinations);
                    addEdge(graph, destinations, source);
                }

            }
        }
        return graph;
    }


    private void addEdge(Map<Integer,LinkedList<Integer>> graph, int source, int destinations) {
        if(graph.get(source) == null){
            graph.put(source, new LinkedList<>());
        }
        graph.get(source).addLast(destinations);
    }

    private boolean isOneDigitDifference(int s, int d){

        String s1 = Integer.toString(s);
        String d1 = Integer.toString(d);
        int diffCount = 0;
        for(int i=0;i<s1.length();i++) {

            if(s1.charAt(i) != d1.charAt(i)){
                  diffCount++;
            }

            if(diffCount>1){
                return false;
            }

        }

        return diffCount == 1;

    }

    private int findShortestpath(int s, int d, Map<Integer,LinkedList<Integer>> graph) {

        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        Map<Integer,Integer> distanceFromSource = new HashMap<>();
        queue.add(s);
        distanceFromSource.put(s,0);
        while(!queue.isEmpty()){
            int t = queue.poll();
            if(t == d){
                return distanceFromSource.get(t);
            }
            LinkedList<Integer> childs = graph.get(t);
            for(int c:childs) {
                if(distanceFromSource.get(c) == null){
                    queue.add(c);
                    distanceFromSource.put(c, distanceFromSource.get(t) + 1 );
                }
             }


        }

        return -1;


    }
}
