package google.graph;


//https://leetcode.com/discuss/interview-question/494186/Google-Onsite-or-Grasshopper-position/440089

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GrassHopper {


    class Node {

        List<Node> children;
        int data;

    }

    public Map<Integer, Map<Integer, Double>> findProbablity(Node root){


        Map<Integer, Map<Integer, Double>> map = new HashMap<>();  // from Level  to node with Probablity
        map.put(root.data, new HashMap<>());
        map.get(root.data).put(0, 1.0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()){
            level++;

            Node parent = queue.poll();
            int branches = parent.children.size();
            map.putIfAbsent(level, new HashMap<>());
            for (Node children : parent.children) {
                Map<Integer, Double> temp = map.get(level);
                double prob = (double) (map.get(level - 1).get(parent.data) * (1 / branches));
                temp.put(children.data, temp.getOrDefault(children.data, 0.0) + prob);
                queue.offer(children);
            }
        }
       return map;
    }
}
