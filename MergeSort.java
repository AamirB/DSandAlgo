package sort;

import java.util.Arrays;

public class MergeSort {


    public static void main(String args[]){

        int[] arr = {9,8,7,6,5,4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        for(int n: arr)
            System.out.print(n + " ");

    }

    public void mergeSort(int [] arr) {

        if(arr.length <= 1)
            return ;

        sort(arr, 0, arr.length -1);
        //return arr;
    }


    public void sort(int[] arr, int low, int high) {

        if(low < high) {

            int mid = low + (high - low)/2;

            sort(arr, low,  mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }



    }


    public void merge(int[] arr, int low, int mid, int high){

        int[] left = Arrays.copyOfRange(arr, low, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1 , high);

        int l = 0;  int maxL = mid - low + 1;
        int r = 0;  int maxR = high - mid ;
        int i = 1;
        while(l < maxL && r < maxR){

            if(left[l] <= right[r]){   // not working check indexes
                arr[i++] = left[l];
                l++;
            } else {
                arr[i++] = right[r];
                r++;
            }
        }
        while(i < maxL) {
            arr[i] = left[l];
            l++;
            i++;
        }

        while(i <  maxR) {
            arr[i] = right[r];
            r++;
            i++;
        }

    }
}
