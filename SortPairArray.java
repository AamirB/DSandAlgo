package javaTips;

import java.util.Arrays;
import java.util.Comparator;

public class SortPairArray {

    public static void main(String args[]){

        int[][] arr = { {2,3}, {3,4},{1,2},{2,5}};

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(o1[0],o2[0]);
            }
        });

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i][0] + " " +arr[i][1]);
        }


        String[] word ={ "qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya","lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"};
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        for(int i=0;i<word.length;i++){
            System.out.println(word[i]);
        }

    }


}
