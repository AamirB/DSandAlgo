package binarySearch;

public class MissingNumber {

    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 6, 3, 7, 8};
        int start = 0;
        int end = arr.length -1 ;
        int result = -1;
        while(start <=end) {
            int  mid = start + (end-start)/2;


            if(mid == arr[mid]){
                start = mid + 1;
            } else {
                result = mid;
                end = mid -1;
            }
        }

    }
}
