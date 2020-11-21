package google.dp;

import java.util.Arrays;

public class PallindromePartition {

    //private static int size = 100;
    private static int[][] dp;

    public static void main(String args[]) {
        String s = "aabb";
        dp = new int[s.length()+1][s.length()+1];
        PallindromePartition p = new PallindromePartition();
        for(int i=0;i<s.length();i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(p.pallindromePartitionMemoize(s,0,s.length()-1));

        for(int i=0;i<=s.length();i++) {

            for(int j=0;j<=s.length();j++){
                if(dp[i][j] != -1){
                    System.out.println(s.substring(i,j));
                }

            }

        }

    }


    public int pallindromePartitionRecur(String s, int i , int j) {

        if(i>=j)
            return 0;

          if(isPallindrom(s,i,j))
              return 0;

        int ans = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){

            int temp = pallindromePartitionRecur(s,i,k) + pallindromePartitionRecur(s,k+1,j) + 1;
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    public int pallindromePartitionMemoize(String s, int i , int j) {

        if(i>=j){
            dp[i][j] = 0;
            return 0;
        }


        if(dp[i][j] != -1)
            return dp[i][j];

        if(isPallindrom(s,i,j)) {
            dp[i][j] = 0;
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k=i;k<j;k++) {

            int t = pallindromePartitionMemoize(s,i,k) + pallindromePartitionMemoize(s,k+1,j) + 1;
            ans = Math.min(t, ans);
        }
        dp[i][j] = ans;
        return ans;
    }

    private boolean isPallindrom(String s, int i, int j) {

        if(  dp[i][j] == 0)
            return  true;

        while(i<j){

            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }

        }

        return true;
    }
}
