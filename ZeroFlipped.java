import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ZeroFlipped {


    public static void main(String args[]){


        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};

        int k = 2;

     int wL=0;
     int wH =0;
     int bestL=0;
     int bestWindow =0;
     int zeroCount = 0;
     while (wH<arr.length) {


         if(arr[wH]==0 && zeroCount<k){
             zeroCount++;
             wH++;
         }

         if(arr[wH]==0){

         }

     }

    }
}
