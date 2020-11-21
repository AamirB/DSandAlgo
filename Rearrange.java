package array;


//Rearrange an array such that arr[i] = i
// https://www.geeksforgeeks.org/rearrange-array-arri/

public class Rearrange {


    public static void main(String args[]) {

        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
       // reArrange(arr);
        int[] arr1 = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        reArrangePostiveAndNegative(arr1);




    }


    // such that arr[i] = i
    public static void reArrange(int[] arr){
        for(int i=0; i<arr.length;i++){

            if(arr[i] == -1){
                continue;
            }

            while(arr[i] != i  && arr[i] != -1){
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        printArray(arr);


    }



    public static void printArray(int[]  arr){
        for(int n : arr){
            System.out.print(n + " ");
        }
    }


    public static void reArrangePostiveAndNegative(int[] arr){

        int i = -1;

        for(int j=0;j<arr.length;j++){

            if(arr[j]<0){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

        printArray(arr);

    }

    public static void reArrangeAlternatePostiveAndNegative(int[] arr){

        int i = -1;

        for(int j=0;j<arr.length;j++){

            if(arr[j]<0){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

        printArray(arr);

        int neg = 0; int pos = i+1;


    }
}
