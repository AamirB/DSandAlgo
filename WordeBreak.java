package google.dp;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordeBreak {


   public static void main(String args[]){
       Object a = new Object();

       //Map<String, Object> map = (Map<String, Object> map)a;
       HashMap<String, String>[] maps = (HashMap<String, String>[]) a;
   }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordsDictionary = new HashSet<>(wordDict);
        return wordBreakRecur(s, wordsDictionary, 0, s.length());
    }


    public boolean wordBreakRecur(String str, Set<String> wordsDictionary, int s, int e){



        if(s >e){
            return false;
        }



       // System.out.println("Word "+str.substring(s,e));

        if(wordsDictionary.contains(str.substring(s,e))){
            return true;
        }


        for(int i=s+1;i<e;i++){

            System.out.println("Word1 "+str.substring(s,i));
            System.out.println("Word2 "+str.substring(i,e));
            boolean r= wordBreakRecur(str,wordsDictionary,s,i) && wordBreakRecur(str,wordsDictionary,i,e);
            if(r)
                return true;
        }
        return false;

    }



}