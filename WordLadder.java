package google.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


//https://leetcode.com/discuss/interview-question/274233/Google-or-Onsite-or-Transform-one-string-into-another-with-find-and-replaceAll

// https://leetcode.com/problems/word-ladder/

// Check this similar https://leetcode.com/discuss/interview-question/138194/Google-or-Phone-screen-or-Longest-movie-title

public class WordLadder {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> wordDict = new HashSet<>(wordList);
        // Map<String, List<String>> graph = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        int dest = 0;
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String top = queue.poll();

                if(top.equals(endWord)){
                    return dest+1;
                }

                //if(visited.contains(top))

                List<String> neighbours = findNeighbours(top, wordDict);

                for(String s:neighbours){

                    if(!visited.contains(s)){
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
            dest++;



        }
        return 0;
    }


    private static List<String> findNeighbours(String top, Set<String> wordDict){

        List<String> neighbours = new ArrayList<>();
        StringBuilder sb = new StringBuilder(top);

        for(int i=0;i<top.length();i++){
            sb = new StringBuilder(top);
            for (int ch = 'a'; ch <= 'z'; ch++) {
                sb.setCharAt(i,(char)ch);
                //System.out.println(sb.toString());
                if(wordDict.contains(sb.toString())){
                    neighbours.add(sb.toString());
                }
            }

        }
        return neighbours;

    }
}


