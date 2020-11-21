package google.graph;


//https://leetcode.com/discuss/interview-question/353830/Google-or-Phone-Screen-or-Parallel-Job-Scheduling

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// DO topological sort and then find the longest path in DAG Very important problem
public class ParallelJobScheduling {


    public int minTime(int[] times, int[][] relations){

           int[] indegree = new int[times.length];

           int[] maxtime = new int[times.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
           for(int [] relation : relations){
               indegree[relation[1]]++;
               map.putIfAbsent(relation[1], new ArrayList<>());
               map.get(relation[0]).add(relation[1]);
           }

        int longest = 0;
           Queue<Integer> queue = new LinkedList<>();
           for(int i=0;i<times.length;i++){
               if(indegree[i] == 0){
                   queue.add(i);
                   maxtime[i] = times[i];
                   longest = Math.max(longest, maxtime[i]);
               }
           }

           while(!queue.isEmpty()){

                Integer t = queue.poll();

                for( Integer child : map.get(t)){
                    maxtime[child] = Math.max(maxtime[child] + times[t], maxtime[child]);
                    longest = Math.max(longest, maxtime[child]);
                    indegree[child]--;
                    if(indegree[child]==0){
                        queue.add(child);
                    }

                }

           }



     return longest;
    }
}
