package string;

import java.util.Map;

public class RabinKarp {

// check this https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java

    public static final int PRIME = 3;

    public static void main(String args[]) {


        String pattern = "abc";
        String text  = "xabc";

        RabinKarp rabinKarp = new RabinKarp();
        System.out.println(rabinKarp.findPatternIndex(text, pattern));

    }





    public int findPatternIndex(String text, String pattern){


           int patternHash = calculateHash(pattern);
           int textCurrentHash = calculateHash(text.substring(0,pattern.length()));

           if(patternHash == textCurrentHash){
               return 0;
           }


           for(int i=pattern.length();i<text.length()-pattern.length();i++){



               if(patternHash == textCurrentHash){
                   // TODO if hash matched then check for string comparision
                   return i;
               }
               textCurrentHash = rollBackHash(text, i, i-pattern.length()+1, textCurrentHash);

           }

           return -1;

    }


    public  int calculateHash(String str){

         int power=0;
//         int

        int hashCode = 0;
         for(char ch : str.toCharArray()){


             hashCode = hashCode + ((ch) * (int)Math.pow(PRIME, power));
             power++;

         }
         return hashCode;

    }


    public int rollBackHash(String str, int indexAdd,int oldIndex,  int currentHash ){
        currentHash = currentHash - str.charAt(oldIndex);
        currentHash = currentHash/PRIME;
        currentHash = currentHash + (int)(str.charAt(indexAdd)*Math.pow(PRIME, str.length()-1));
        return currentHash;

    }
}


