package graph;


//https://www.geeksforgeeks.org/minimum-steps-reach-end-array-constraints/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumStepsToReachEnd {



    public static void main(String args[]){
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 5,4, 3, 6, 0, 1, 2, 3, 4, 5, 7};
        System.out.println("MIN STEPS "+minSteps(arr));

    }



    private static int minSteps(int[] arr){


       Queue<Integer> queue = new LinkedList<>();

       queue.add(0);

       //source Index = 0
       Map<Integer, Integer> distanceOfIndexFromSource = new HashMap<>();
       distanceOfIndexFromSource.put(0,0);

       while(!queue.isEmpty()){



           int index = ((LinkedList<Integer>) queue).pop();

            if(index == arr.length-1){
                System.out.println(distanceOfIndexFromSource);
                return distanceOfIndexFromSource.get(index) + 1;
            }

            List<Integer> possibleIndex = getPossibleJump(arr,index);

            for(Integer i:possibleIndex){

                if(distanceOfIndexFromSource.get(i) != null){
                    continue;
                }
                queue.add(i);
                distanceOfIndexFromSource.put(i, distanceOfIndexFromSource.get(index)+1);

            }


       }


       System.out.println(distanceOfIndexFromSource);

       return -1;
    }


    private static List<Integer> getPossibleJump(int[] arr, int index){
        List<Integer> jumps = new ArrayList<>();

        if(index-1>=0 && arr[index-1]+index<arr.length){
            int left = arr[index-1];
            jumps.add(left+index);
        }

        if(index+1<arr.length && arr[index+1]+index< arr.length){
            int right = arr[index+1];
            jumps.add(right+index);
        }


        if(arr[index] ==index && arr[index]+index< arr.length ){
            jumps.add(index+index);
        }

        System.out.println(" Possible Jumps for Index "+ index + " =" + jumps);
        return jumps;
    }
}
