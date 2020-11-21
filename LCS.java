package google.dp;

import java.util.Arrays;

public class LCS {


    public static void main(String args[]) {

        String s1 = "abac";
        String s2 = "cab";
        LCS lcs = new LCS();
        System.out.println("Recursion LCS " +lcs.lcsRecur(s1,s2,s1.length(),s2.length()));
        System.out.println("Top Down LCS " +lcs.lcsTopDown(s1,s2));
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        lcs.lcsMemoizations(s1,s2,s1.length(),s2.length(),dp);

        System.out.println("Memoizations LCS " +dp[s1.length()][s2.length()]);
        System.out.println("Printing Common Subsequence "+lcs.getCommonSubsequence(dp,s1,s2));
        System.out.println("Printing Shortest Super Subsequence "+lcs.getShortestSuperSequence(dp,s1,s2));

    }


    public int lcsRecur(String s1, String s2, int i, int j) {

        if(i==0 || j==0) {
            return 0;
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return 1 + lcsRecur(s1,s2,i-1, j-1);
        }

        return Math.max(lcsRecur(s1,s2,i-1,j), lcsRecur(s1,s2,i,j-1));
    }


    public int lcsTopDown(String s1, String s2) {

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<=s1.length();i++) {

            for(int j=0;j<=s2.length();j++) {

                if(i==0 || j==0){
                    dp[i][j]=0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

     return dp[s1.length()][s2.length()];

    }

    public int lcsMemoizations(String s1, String s2, int i, int j, int[][] dp) {

        if(i==0 || j==0){
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            int val = 1 + lcsMemoizations(s1,s2,i-1,j-1,dp);
            dp[i][j] = val;
            return val;
        }

        int val = Math.max(lcsMemoizations(s1,s2,i-1,j,dp), lcsMemoizations(s1,s2,i,j-1,dp));
        dp[i][j] = val;
        return val;
    }


    public String getCommonSubsequence(int [][]dp, String s1, String s2) {
        StringBuilder commonSubsequence = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while(true) {
            if(i ==0 || j ==0)
                return commonSubsequence.reverse().toString();

            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                commonSubsequence.append(s1.charAt(i-1));
                i = i-1;
                j = j-1;
            } else {
                if(dp[i-1][j]>dp[i][j-1]){
                    i = i-1;
                } else {
                    j = j-1;
                }

            }

        }
    }


    public String getShortestSuperSequence(int[][] dp, String s1, String s2) {
        StringBuilder superSequence = new StringBuilder();
        int i = s1.length();
        int j = s2.length();

        while(true) {
            if(i ==0 || j ==0) {
                break;
            }
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                superSequence.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                superSequence.append(s1.charAt(i-1)).append(s2.charAt(j-1));
                if(dp[i-1][j]>dp[i][j-1]){
                    i = i-1;
                } else {
                    j = j-1;
                }
            }
        }
        while(i != 0 ){
            superSequence.append(s1.charAt(i-1));
            i--;
        }
        while(j !=0 ){
            superSequence.append(s2.charAt(j-1));
            j--;
        }
        return superSequence.reverse().toString();
    }

}
