package tree;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapBST {


    public static void main(String args[]) {

        int[] arr = { 6, 7, 8, 1, 2, 3, 9, 10};
        TreeMap<Integer, TreeNode> maxTillNow = new TreeMap<>();
        //maxTillNow.put(0, new TreeNode(0));

//        for(int n : arr){
//            System.out.println(" larger than "+ n + " is " + maxTillNow.floorEntry(n));
//            maxTillNow.put(n, new TreeNode(n));
//        }

        TreeMap<Integer, TreeNode> maxAfterNow = new TreeMap<>();  //max on up
       // maxAfterNow.put(0, new TreeNode(0));


        System.out.println();
        System.out.println();
        System.out.println();

//
        for(int i=arr.length-1;i>=0;i--){
            //System.out.println(" larger than "+ arr[i] + " is " + maxAfterNow.ceilingEntry(arr[i]));
            maxAfterNow.put(arr[i], new TreeNode(arr[i]));
        }

        int n = arr.length-1;

       for(int i=0;i<arr.length;i++){
           System.out.println(" max smaller than "+ arr[i] + " is " + maxTillNow.floorEntry(arr[i]));
           maxAfterNow.remove(arr[i]);
           System.out.println(" max larger than "+ arr[i] + " is " + maxAfterNow.lastEntry());
           maxTillNow.put(arr[i], new TreeNode(arr[i]));
           System.out.println();
          // maxTillNow.put(n, new TreeNode(n));
          // maxAfterNow.put(arr[i], new TreeNode(arr[n-i]));



       }


       // System.out.println(maxTillNow.lastEntry());


// Treeset if not duplicate
        TreeSet<TreeNode> set = new TreeSet<TreeNode>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        set.add(new TreeNode(1));
        set.add(new TreeNode(2));
        set.add(new TreeNode(3));
        System.out.println(set);

    }
}
