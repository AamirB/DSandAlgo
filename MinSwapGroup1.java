public class MinSwapGroup1 {


    public static void main(String args[]) {


        int arr[] = {0, 0, 1, 0,
                1, 1, 0, 0, 1};
        int oneCount=0;
        for(int i=0;i<arr.length;i++) {

            if(arr[i]==1){
                oneCount++;
            }

        }

        int maxOneCountofSubarray=0;

        for(int i=0;i<oneCount;i++){
            if(arr[i]==1){
                maxOneCountofSubarray++;
            }
        }
        int currCount = maxOneCountofSubarray;
        for(int i=1;i<arr.length-oneCount+1;i++){
             if(arr[i+oneCount-1]==1){
                 currCount++;
             }
             if(arr[i-1]==1){
                 currCount--;
             }

             if(currCount>maxOneCountofSubarray){
                 maxOneCountofSubarray = currCount;
             }
        }

        System.out.println("Answer "+ (oneCount-maxOneCountofSubarray));

    }

}
