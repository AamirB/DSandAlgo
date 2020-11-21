import java.util.PriorityQueue;

public class KMaxSumNonOverlapping {


    public static void main(String args[]) {
        int[] arr = {4,1,1,-1,-3,-5,6,2,-6,-2};
        int k = 3;

        PriorityQueue<Integer> maxSum = new PriorityQueue<Integer>();


        int max = Integer.MIN_VALUE;
        int currsum = 0;

        for(int i=0;i<arr.length;i++) {

            currsum = currsum + arr[i];
            if(currsum > max) {
                //currsum = max;
                max = currsum;
            } else if(currsum<max) {
                maxSum.add(currsum-arr[i]);
                //max = arr[i];
                currsum = arr[i];
                if(maxSum.size()>k){
                    maxSum.poll();
                }

                //currsum = arr[i];
            }



        }

        while(!maxSum.isEmpty()) {
            System.out.println(maxSum.poll());
        }

    }

}

