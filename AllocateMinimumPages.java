package binarySearch;

public class AllocateMinimumPages {

    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k = 5;
        AllocateMinimumPages allocateMinimumPages = new AllocateMinimumPages();
        System.out.println(allocateMinimumPages.minPage(arr, k));
    }


    public int minPage(int[] arr, int k) {

        if(arr.length<k){
            System.out.println("NOT ENOUGH BOOKS");
            return -1;
        }

        int start = findMax(arr);
        int end = sum(arr);
        int minPage = -1;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(isValidPageAllocations(arr,mid,k)){
                minPage = mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }

        return minPage;

    }

    private boolean isValidPageAllocations(int[] arr, int mid, int k) {


        //System.out.println("MID GOT "+mid);
        int totalDistribution =0;
        int currPage = 0;
        for(int n:arr){

            if (n> mid || totalDistribution > k) return false;

            if(currPage + n <= mid){
                currPage = currPage + n;
            } else {
                totalDistribution++;
                currPage = n;
            }

            if(totalDistribution>k){
                return false;
            }
        }
        if(currPage !=0){
            totalDistribution++;
        }
        if(totalDistribution>k){
            return false;
        }
        return true;
    }

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int n:arr){
            max = Math.max(n, max);
        }
        return max;
    }

    private int sum(int[] arr) {
        int sum = 0;
        for(int n:arr){
            sum = sum + n;
        }
        return sum;
    }
}
