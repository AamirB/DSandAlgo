public class SubArraysRange {


    public static void main(String args[]) {


        int L =3;
        int R = 8;
        int arr[] = {1,4,6};

        int smallerThanL = findSmaller(arr,L-1);
        int smallerThanR = findSmaller(arr,R);
        System.out.println( "Results "+ (smallerThanR - smallerThanL));

    }

    private static int findSmaller(int[] arr, int k) {
        int count =0;

        int start = 0;
        int end = 0;
        int sum =0;

        while(end < arr.length) {
            sum = sum + arr[end];

            while(start<=end && sum>k) {
                sum = sum - arr[start];
                start++;
            }
                count = count + (end-start+1);
            end++;
        }


        return count;


    }



}
