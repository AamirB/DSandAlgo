import java.util.Collections;
import java.util.PriorityQueue;

public class KMAXSUM {


    public static void main(String args[]) {


        int []arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int[] prefixsum = new int[arr.length];
        prefixsum[0]=arr[0];
        for(int i=1;i<arr.length;i++) {
            prefixsum[i] = prefixsum[i-1]+arr[i];
        }
        int k =3;

       // int maxsum =arr[0];
        int minPrefixSum =prefixsum[0];
        //int currsum = arr[0];
                PriorityQueue<Integer> min = new PriorityQueue<>();
       min.add(prefixsum[0]);
        for(int i=1;i<arr.length;i++) {
           // currsum = currsum + arr[i];
            min.add(prefixsum[i] - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum,prefixsum[i]);
            if(min.size()>k){
                min.poll();
            }

        }


        while (!min.isEmpty()){
            System.out.println(min.poll());
        }

    }

}
