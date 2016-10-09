package dp;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int test=sc.nextInt();
        
        while(test!=0){
            
            int n=sc.nextInt();
            int sumsP=sc.nextInt();
            int[] sum=new int[n];
            
            for(int i=0;i<n;i++){
                sum[i]=sc.nextInt();
            }
            
            System.out.println(SumMinimize(sum,sumsP));
            test--;
        }
        
        
    }
    
    public static int SumMinimize(int []sums,int w){
        int len=sums.length;
        int [][] dp=new int[len+1][w+1];
        
        
        for(int i=0;i<=w;i++){
        	
        	if(sums[0]>i){
        		dp[0][i]=0;
        	}else{
        		dp[0][i]=sums[0];
        	}
        }
        
        for(int i=0;i<=len;i++){
        	dp[i][0]=0;	
        }
    
        for(int i=1;i<=len;i++){
            for(int j=1;j<=w;j++){
                
                if(sums[i]>j){
                    dp[i][j]=dp[i-1][j];
                    
                }else{
                	int r=Math.max(dp[i][j-sums[i]],dp[i-1][j]);
                    dp[i][j]=Math.max(r,sums[i]+dp[i-1][j-sums[i]]);
                }
                
            }
        }
        UtilityClass.printtable(dp);
        return dp[len][w];
    }
    
}