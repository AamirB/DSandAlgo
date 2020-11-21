import google.dp.CountIntegerPartitions;
import google.dp.SubsetSum;
import tree.TreeNode;

import java.util.*;

public class Test {

    public static void main(String args[]) {


        CountIntegerPartitions p = new CountIntegerPartitions();

        TreeMap<Integer, Integer> count = new TreeMap<>();
        count.put(7, 4);
        count.put(6, 2);
        count.put(8, 2);
        Map.Entry<Integer, Integer> enty = count.lowerEntry(8);

        NavigableMap<Integer, Integer> t = count.headMap(7, false);
        int res = 0;
        Set<Integer> key = t.keySet();

        for(Integer k : key){
            res = res + count.get(k);
        }


        System.out.println(res);


    }











}
