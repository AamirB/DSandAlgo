import java.util.PriorityQueue;

public class KContinuousMaxSum {


    public static void main(String args[]) {
       int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
       int k = 3;
       int[] sum = new int[arr.length];
        sum[0] = arr[0];
       for(int i=1;i<arr.length;i++) {
            sum[i]= sum[i-1] + arr[i];
       }
        PriorityQueue<Integer> min = new PriorityQueue();

//       for(int i=0;i<arr.length;i++) {
//
//           for(int j=i;j<arr.length;j++){
//               int subMax = sum[j] - sum[i] + arr[i];
//               min.add(subMax);
//               if(min.size()>k) {
//                   min.poll();
//               }
//           }
//
//       }

       int res = Integer.MIN_VALUE;
       int minprefix = 0;
       int prev = -1;
       for(int i=0;i<arr.length;i++) {
           res = Math.max(res, sum[i] - minprefix);
            if(prev != res){
                min.add(res);
            }

           minprefix = Math.min(minprefix, sum[i]);

           if(min.size()>k) {
               min.poll();
           }
           prev = res;
       }

       while(!min.isEmpty()) {
            System.out.println(min.poll());
       }



    }
}
