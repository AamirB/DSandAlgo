package google.graph;


//https://leetcode.com/discuss/interview-question/569802/Google-or-Phone-or-Print-Hierarchy


// Good DFS Problem
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



public class PrintHierarchy {


    public static void main(String args[]){

        String[][] strs = { { "dog", "poodle" }, { "mammal", "dog" }, { "mammal", "cat" }, { "dog", "bulldog" },
                { "dog", "terrier" } , { "cat", "lolo" }};

        solve(strs);
    }

    private static void solve(String[][] strs) {

        Map<String, Set<String>> map = new HashMap<>(); // building map
        Map<String, Integer> cntMap = new HashMap<>();  // find the indegree
        for(String[] ss : strs) {
            map.putIfAbsent(ss[0], new HashSet<>());
            map.get(ss[0]).add(ss[1]);
            cntMap.putIfAbsent(ss[0], 0);
            cntMap.put(ss[1], cntMap.getOrDefault(ss[1], 0) + 1);
        }

        for(Map.Entry<String, Integer> e : cntMap.entrySet()) {
            if(e.getValue() == 0){
                dfs(map, e.getKey(), "");  // starte with indegree zero means top level
            }
        }





    }

    private static void dfs(Map<String, Set<String>> map, String key, String space) {
        System.out.println(space + key);
        for(String nei : map.getOrDefault(key, new HashSet<>())) {
            dfs(map, nei, space + "    ");
        }
    }
}
