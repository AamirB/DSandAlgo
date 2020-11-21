package google.dp;

public class SubsetSum {

    public static void main(String args[]) {

        int arr []= {3, 34, 4, 12, 5, 2};
        int sum = 11;
        SubsetSum SubsetSum = new SubsetSum();
        System.out.println(SubsetSum.doesSubSetExistTopDown(arr,sum,arr.length));
    }



    public boolean doesSubSetExist(int arr[], int sum, int n) {

        if(sum<0 || n<=0)
            return false;
        if(sum ==0)
            return true;
        return doesSubSetExist(arr,sum-arr[n-1],n-1)
                || doesSubSetExist(arr,sum,n-1);

    }

    public boolean doesSubSetExistTopDown(int arr[], int sum, int n) {

        boolean dp[][] = new boolean[arr.length+1][sum+1];

        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<sum+1;j++) {

                if(i==0){
                    dp[i][j] = false;
                } else if( j==0){
                    dp[i][j] = true;
                } else if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j-arr[i-1]] ||dp[i-1][j];
                }

            }
        }

        if(dp[n][sum]){
            printSubset(dp,n,sum,arr);
        }

        return dp[n][sum];

    }


    public void printSubset(boolean[][] dp,int n, int sum, int arr[]) {
        System.out.println("Printing subset...");

        int i=n;
        int j= sum;


        while(i != 0 || j != 0) {


                if(j-arr[i-1]>=0 &&dp[i-1][j-arr[i-1]]){
                    System.out.println(arr[i-1]);
                    j= j-arr[i-1];
                    i--;
                } else  {
                    i--;
                }

            }


    }
}
