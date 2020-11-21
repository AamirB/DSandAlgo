public class Misc {



    public static void main(String args[]) {


        int arr[] = {1, 5, 8, 9, 6, 7, 3, 4, 2, 0 };
        //insertionsort(arr);
        ksmallest(arr,5);

    }


    private static void insertionsort(int [] arr) {

       // int i=1;


        for(int i=1;i<arr.length;i++) {
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;

        }

        printArray(arr);

    }


    private static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }



    public static void ksmallest(int[] arr,int k) {

        if(k>arr.length-1){
            return;
        }

        for(int i=k-1;i<arr.length;i++) {

            int key = arr[i];
            int j= i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;

            }
            arr[j+1]=key;


        }
        System.out.println("Smallest k element is ");
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+ " ");
        }

    }
}
