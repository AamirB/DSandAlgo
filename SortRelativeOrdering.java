package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortRelativeOrdering {

    public static void main(String args[]){

        //int[] arr = {1, 34, 3, 98, 9, 76, 45, 4};

       Integer  A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};

        Map<Integer, Integer> keyToIndex = new HashMap<>();
        for(int i=0;i< A2.length;i++){
            keyToIndex.put(A2[i], i);
        }



        List<Integer> s = Arrays.asList(A1);

        Collections.sort(s, new Comparator<Integer>(){

            @Override
            public int compare(Integer a, Integer b){



                if(keyToIndex.get(b) == null && keyToIndex.get(a) == null){
                    return -1;
                }

                if(keyToIndex.get(a) == null ){
                     return 1;
                }

                if( keyToIndex.get(b) == null){
                    return -1;
                }


                return keyToIndex.get(a) - keyToIndex.get(b);

            }

        });

System.out.println(s);




    }
}
