package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenerateBiggestNumber {

    public static void main(String args[]){

        Integer[] arr = {1, 34, 3, 98, 9, 76, 45, 4};

        Arrays.asList(arr);
        List<String> s = new ArrayList<>();
        for(int n : arr){
            s.add(Integer.toString(n));
        }

        Collections.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.concat(o1).compareTo(o1.concat(o2));
            }
        });
    StringBuilder sb = new StringBuilder();

        for(String s1: s){
            sb.append(s1);
        }
        System.out.println(sb.toString());




    }
}
