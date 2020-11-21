package google.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/414064/google-count-integer-partitions
// same as coin change
public class CountIntegerPartitions {


    public static void main(String args[]){

            int N = 5;

            int[] arr = new int[N+1];
            for(int i=0;i<arr.length;i++){
                arr[i] = i;
            }

        CountIntegerPartitions  countIntegerPartitions = new CountIntegerPartitions();
        System.out.println(countIntegerPartitions.countIntegerPartitions(N, arr, 1)-1);
    }

    private int countIntegerPartitions(int N, int[] arr, int start){


        if(N==0)
            return 1;

        if(N<0)
            return 0;


        if(start>= arr.length ){
            return 0;
        }

//        if(arr[start]>N && N>0){ // sorted array so returning here
//            return 0;
//        }



        return countIntegerPartitions(N-arr[start],arr, start) + countIntegerPartitions(N,arr, start+1);

    }

    //https://leetcode.com/discuss/interview-question/353317/Google-or-Onsite-or-Number-of-Valid-Strings
    public static class CountValidString {


        public static void main(String args[]) {
            int N = 1;
            CountValidString countValidString = new CountValidString();
            List<String> validString = new ArrayList<>();
            countValidString.countValidString(N, new StringBuilder(), validString);
            System.out.println("Result "+ validString.size());
            System.out.println("Result Strings"+ validString);

        }

        public void countValidString(int n, StringBuilder s, List<String> validString) {


            if(!validCount(s)){
                return ;
            }

            if (n == 0 && validCount(s)){
                validString.add(s.toString());
                return ;
            }

            if(n<0){
                return ;
            }

            countValidString(n-1, s.append('A'), validString );
            s.setLength(s.length()-1);
            countValidString(n-1, s.append('B'), validString );
            s.setLength(s.length()-1);
            countValidString(n-1, s.append('C'), validString );
            s.setLength(s.length()-1);

        }


        private boolean validCount(StringBuilder sb){


            String s = sb.toString();

            int [] charCount = new int[3];
            for(int i=0;i<s.length()-2;i++){

                charCount[s.charAt(i)-'A']++;
                charCount[s.charAt(i+1)-'A']++;
                charCount[s.charAt(i+2)-'A']++;

                if(charCount[0]==1 && charCount[1]==1 && charCount[2]==1){
                    return false;
                } else {
                    charCount = new int[3];
                }
            }

            return true;

        }
    }

    //Count Zero Squares  https://leetcode.com/discuss/interview-question/416012/Google-or-Phone-Screen-or-Count-Zero-Squares
    public static class CountZeroSquares {

        public static void main(String args[]){


           int[][] matrix =  {{0, 0, 0},
                             {0, 0, 0},
                             {0, 0, 1}};

            CountZeroSquares countZeroSquares = new CountZeroSquares();
            System.out.println(countZeroSquares.countZeroSquares(matrix));
        }


          public int countZeroSquares(int[][] matrix){

              int rows = matrix.length;
              int cols = matrix[0].length;
           int count = 0;
              int[][] dp = new int[rows + 1][cols + 1];



              for(int i=1;i<=matrix.length;i++){

                  for(int j=1;j<=matrix[0].length;j++){

                      if(matrix[i-1][j-1] == 0){
                          dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                          count = count + dp[i][j];
                      }
                  }
              }

            return count;
        }
    }

    // THink knapsack as well
    public static class DotProductCloseToTarget {

        public static void main(String args[]){
            int [] nums = {1, 2, 2, 1};
            int target = 4;
            List<List<Integer>> elementSumCloseToTagret = new ArrayList<>();
            findElementSumCloseToTarget(elementSumCloseToTagret, new ArrayList<>(), nums, target,0);
            System.out.println(elementSumCloseToTagret);
            int [] res = new int[nums.length];
            Arrays.fill(res,0);

        }


        private static void findElementSumCloseToTarget(List<List<Integer>> elementSumCloseToTagret, List<Integer> currList,
                                                 int[] nums, int target, int start){


                 if(target >= 0){
                     elementSumCloseToTagret.add(new ArrayList<>(currList));
                    // return;
                 }

                 if(target<0 || start>=nums.length)
                     return;

                 for(int i=start;i<nums.length;i++){

                     if(nums[i]>target){
                         continue;
                     }
                     currList.add(i);
                     findElementSumCloseToTarget(elementSumCloseToTagret, currList, nums, target-nums[i], i+1);
                     currList.remove(currList.size()-1);
                 }


        }



    }

    // https://leetcode.com/discuss/interview-question/371677/Google-or-Onsite-or-Min-Deletions-to-Make-Palindrome
    public static class MinDeletionToConvertToPallindrome {


        public static void main(String args[]){

            String s = "aebcbda";
            MinDeletionToConvertToPallindrome minDeletionToConvertToPallindrome = new MinDeletionToConvertToPallindrome();
            System.out.println(minDeletionToConvertToPallindrome.minDeletionsToConvertToPallindrome(s));
        }

        public int minDeletionsToConvertToPallindrome(String s) {

            if(s.length() ==0)
                return 0;

            String reverse = new StringBuilder(s).reverse().toString();

            int lcs = longestCommonSubsequence( s, reverse);

            return s.length()-lcs;

        }


        public int longestCommonSubsequence(String s1, String s2) {

            int len = s1.length();
            int lcs [][] = new int[len+1][len+1];

            for(int i=1;i<=len;i++) {

                for(int j=1; j<=len;j++){


                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        lcs [i][j] = 1 + lcs[i-1][j-1];
                    } else {
                        lcs [i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                    }

                }

            }

            return lcs[len][len];


        }

    }

    // https://www.geeksforgeeks.org/convert-to-strictly-increasing-integer-array-with-minimum-changes/
    public static class MinimumDeletionTOMakeArrayIncreasing {


        public static void main(String args[]){

            int[] arr = { 1, 2, 6, 5, 4};
            MinimumDeletionTOMakeArrayIncreasing minimumDeletionTOMakeArrayIncreasing = new MinimumDeletionTOMakeArrayIncreasing();
            System.out.println(arr.length - minimumDeletionTOMakeArrayIncreasing.minDeletions(arr));
        }

        public int minDeletions(int[] arr){

            if(arr.length==0)
                return 0;

            int[] LIS = new int[arr.length];

            Arrays.fill(LIS,1);
            int maxLen = 0;
            for(int i=1;i<arr.length;i++){
                for(int j=0;j<i;j++){

                    if(arr[i]> arr[j]){
                        LIS[i] = Math.max(LIS[j]+1, LIS[i]);
                        maxLen = Math.max(LIS[i], maxLen);
                    }

                }
            }

           return maxLen;
        }
    }

    public static class MiniMumOperationsToReduceToOne {


        public static void main(String args[]){

            MiniMumOperationsToReduceToOne miniMumOperationsToReduceToOne = new MiniMumOperationsToReduceToOne();
            System.out.println(miniMumOperationsToReduceToOne.minOperations(8));
        }


        public int minOperations(int n){

            int operations[] = new int[n+1];

            operations[0]= 0;
            operations[1] = 0;
            operations[2] = 1;


            for(int i=3;i<=n;i++){

                int min = 1 + operations[i-1];
                if(i%2==0){
                    min =  Math.min(min, 1 + operations[i/2]) ;
                }

                if(i%3==0){
                    min = Math.min(min, 1 + operations[i/3]);
                }

                operations[i] = min;

            }

            return operations[n];
        }
    }

    public static class MiniMumSuffix {

        public static void main(String args[]){

            String A = "vvav";
            String B = "vav";
            System.out.println(getMinimumSuffix(A, B));

        }

        public static  int getMinimumSuffix(String A, String B){


            Set<String> suffixB = new HashSet<>();

            for(int i=0;i<B.length();i++){
                suffixB.add(B.substring(i));
            }

            System.out.println(suffixB);

            int [] dp = new int[A.length()+1];
            Arrays.fill(dp, -1);

            dp[0] = 0;
            // LIS pattern

            for(int i=1;i<=A.length();i++){
                for(int j=0;j<i;j++){

                    if(dp[j]>=0 && suffixB.contains(A.substring(j,i))){
                        dp[i] = dp[i] < 0 ? (dp[j] + 1): Math.min(dp[i], dp[j] + 1);
                    }

                }
            }

            return dp[A.length()];

        }
    }

    public static class StringFormed {

        public static List<String> resultRecursion = new ArrayList<>();

        static int[][][] dp;

        public static void main(String args[]) {
            List<String> result = new ArrayList<>();
            StringFormed stringFormed = new StringFormed();
                        stringFormed.constructStringBackTracking(new StringBuilder(), result, 3, 1, 2);
                        System.out.println(result);
            System.out.println("RESULT SIZE " +result.size());

            int N = 3;
            int b = 1;
            int c = 2;
            System.out.println("RESULT RECURSION SIZE" + stringFormed.countStringRecursion(3,1,2, new StringBuilder()));
            System.out.println("RESULT RECURSION " +resultRecursion);

            dp = new int[N+1][b+1][c+1];
            for(int i=0; i<= N;i++){
                for(int j=0;j<= b;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }


            System.out.println("RESULT DP " +stringFormed.countStringDP(N,1,2, new StringBuilder()));
        }


        public void constructStringBackTracking(StringBuilder str, List<String> result, int N, int atmostA, int atmostC){


            if(str.length()==N && isValid(str.toString(),atmostA,atmostC)){
                result.add(str.toString());
                return;
            }

            if(str.length()>N){
                return;
            }

            if(!isValid(str.toString(), atmostA, atmostC)){
                return;
            }

            StringBuilder includinga = new StringBuilder(str).append('a');
            constructStringBackTracking( includinga,result,  N , atmostA, atmostC);
            includinga.deleteCharAt(includinga.length()-1);
            includinga.append('b');
            constructStringBackTracking( includinga,result, N , atmostA, atmostC);
            includinga.deleteCharAt(includinga.length()-1);
            includinga.append('c');
            constructStringBackTracking( includinga,result, N , atmostA, atmostC);
            includinga.deleteCharAt(includinga.length()-1);

        }

        private boolean isValid(String str, int atmostA, int atmostC) {

                int[] char_count = new int[3];

                for(char ch : str.toCharArray()){
                    char_count[ch-'a']++;
                }

                if(char_count[1]>atmostA || char_count[2]>atmostC){
                    return false;
                }
                return true;

        }


        public int countStringRecursion(int n, int b, int c, StringBuilder str){

            if(b<0 || c<0)
                return 0;

            if(n==0){
                resultRecursion.add(str.toString());
                //System.out.println(str.toString());
                return 1;
            }



            return countStringRecursion(n-1,b,c, new StringBuilder(str).append('a') ) + countStringRecursion(n-1,b-1,c, new StringBuilder(str).append('b')) +
                    countStringRecursion(n-1,b,c-1, new StringBuilder(str).append('c'));


        }

        public int countStringDP(int n, int b, int c, StringBuilder str){

            if(b<0 || c<0)
                return 0;

            if(n==0){
                //resultRecursion.add(str.toString());
                //System.out.println(str.toString());
                return 1;
            }

         if(dp[n][b][c] != -1)
             return dp[n][b][c];

            return countStringRecursion(n-1,b,c, new StringBuilder(str).append('a') ) + countStringRecursion(n-1,b-1,c, new StringBuilder(str).append('b')) +
                    countStringRecursion(n-1,b,c-1, new StringBuilder(str).append('c'));


        }




    }
}
