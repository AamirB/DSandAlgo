package google.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

    private static final int size = 100;

    private static int t[][] = new int[size][size];


    public static void main(String args[]) {
        int arr[] = {10, 20, 30};
        for(int i=0;i<size;i++){
            Arrays.fill(t[i],-1);
        }
        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
        System.out.println(matrixChainMultiplication.solveMinMultiplicationsRecursion(arr,1, arr.length-1));
        System.out.println(matrixChainMultiplication.solveMinMultiplicationsMemoization(arr,1, arr.length-1));
    }


    public int solveMinMultiplicationsRecursion(int arr[], int i, int j) {

        if(i>=j)
            return 0;

        int minCost = Integer.MAX_VALUE;

        for(int k=i;k<j;k++) {

            int cost = solveMinMultiplicationsRecursion(arr,i,k) +
                    solveMinMultiplicationsRecursion(arr, k+1, j)
                    + arr[i-1]*arr[k]*arr[j];

            minCost = Math.min(minCost, cost);

        }

        return minCost;
    }


    public int solveMinMultiplicationsMemoization(int arr[], int i, int j) {

        if(i>=j)
            return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int minCost = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost = solveMinMultiplicationsMemoization(arr,i,k) +
                    solveMinMultiplicationsMemoization(arr,k+1,j)
                    + arr[i-1]*arr[k]* arr[j];
            minCost = Math.min(minCost, cost);
        }

        t[i][j] = minCost;
        return minCost;

    }
}
