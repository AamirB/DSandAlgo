package google.dp;

import java.util.Arrays;

public class BinomialCoefficient {

    public static int[][] dp = new int[100][100];

    public static void main(String [] args){
        for(int i=0;i<100;i++){
            Arrays.fill(dp[i],-1);
        }

        BinomialCoefficient binomialCoefficient = new BinomialCoefficient();
        System.out.println(binomialCoefficient.binomialCoefficient(15,12));
        System.out.println(binomialCoefficient.binomialCoefficientTopDown(15,12));

    }

// f(n,k) = f(n-1,k-1 ) + f(n-1,k)

    public int binomialCoefficient(int n , int k){

        if(k==0 || n==k){
            return 1;
        }

        if(dp[n][k] != -1){
            return dp[n][k];
        }

        dp[n][k] =  binomialCoefficient(n-1,k-1) + binomialCoefficient(n-1,k);
        return dp[n][k];

    }

    public int binomialCoefficientTopDown(int n, int k){
        int[][] dp = new int[n+1][k+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){

                if(j==0 || i==j){
                    dp[i][j]=1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }

            }
        }
        return dp[n][k];
    }



}
