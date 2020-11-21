package google.graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/124569/Google-or-Onsite-or-Horizontal-sum-of-a-binary-tree

//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/CycleInDirectedGraph.java
public class CycleInDirectedGraph {

    Map<Vertex<Integer>, Vertex<Integer>> sourceToParent = new HashMap<>();

    public boolean isCylic(Graph<Integer> graph){

        Set<Vertex<Integer>> notProcessed = new HashSet<>();

        Set<Vertex<Integer>> currentyProcessing = new HashSet<>();

        Set<Vertex<Integer>> alreadyPrcocessed = new HashSet<>();

        Set<Vertex<Integer>> allVertex =  graph.getAllVertex();

        addAllVertexToNotProcessed(allVertex, notProcessed);

        while(!notProcessed.isEmpty()){

            Vertex<Integer> current = notProcessed.iterator().next();
            if(dfs(current, notProcessed, currentyProcessing, alreadyPrcocessed)){
                return true;
            }

        }
        return false;

    }


    public void addAllVertexToNotProcessed( Set<Vertex<Integer>> allVertex, Set<Vertex<Integer>> notProcessed){
        notProcessed.addAll(allVertex);
    }


    public boolean dfs(Vertex<Integer> current, Set<Vertex<Integer>> notProcessed,
                       Set<Vertex<Integer>> currentyProcessing, Set<Vertex<Integer>> alreadyPrcocessed) {

        // move current from notProcessed to  currentyProcessing
        notProcessed.remove(current);
        currentyProcessing.add(current);

        for(Vertex<Integer> neighbour : current.getAdjacentVertex()){

            sourceToParent.put(neighbour, current);
           if(alreadyPrcocessed.contains(neighbour)){
               continue;
           }


           // node which was being processed still comes back means it got other path reaching to it cycle
           if(currentyProcessing.contains(neighbour)){

               //printCycle()
               return true;
           }

            if(dfs(current, notProcessed, currentyProcessing, alreadyPrcocessed)){
                return true;
            }


        }
        // move current from currentyProcessing to  alreadyPrcocessed

        currentyProcessing.remove(current);
        alreadyPrcocessed.add(current);

        return false;



    }
}
