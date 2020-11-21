package google.dp;

import java.util.Arrays;

public class Knapsack01 {


    private static int[][] dp;

    public static void main(String args[]) {

        int weight[] = {10,20,30};
        int price[] = {60,100,120};
        int capacity = 50;
        dp = new int[weight.length+1][capacity+1];
        for(int i=0;i<weight.length+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        Knapsack01 knapsack = new Knapsack01();
       System.out.println(knapsack.knapsackMaxProfit(weight, price, capacity, weight.length));
       System.out.println(knapsack.knapsackMaxProfitMemoizations(weight, price, capacity, weight.length));
       System.out.println(knapsack.knapsackMaxProfitTopDown(weight, price, capacity));

    }


    public int knapsackMaxProfit(int weight[], int price[], int capacity, int n){
        if(capacity == 0 || n ==0)
            return 0;
        if(weight[n-1]>capacity)
            return 0;

        return Math.max(
                price[n-1] + knapsackMaxProfit(weight, price, capacity - weight[n-1], n-1),
                knapsackMaxProfit(weight, price, capacity, n-1)
        );
    }


    public int knapsackMaxProfitMemoizations(int weight[], int price[], int capacity, int n) {

        if(capacity == 0 || n ==0)
            return 0;
        if(dp[n-1][capacity] != -1)
            return dp[n-1][capacity];

        if(weight[n-1]>capacity){
            dp[n-1][capacity] = 0;
            return 0;
        }

        dp[n-1][capacity] = Math.max(
                price[n-1] + knapsackMaxProfit(weight, price, capacity - weight[n-1], n-1),
                knapsackMaxProfit(weight, price, capacity, n-1)
        );

        return dp[n-1][capacity];

    }

    public int knapsackMaxProfitTopDown(int weight[], int price[], int capacity) {

        int [][] t = new int[weight.length+1][capacity+1];
        for(int i=0;i<weight.length+1;i++) {

            for(int w=0; w<capacity+1;w++) {

                if(i==0 || w ==0){
                    t[i][w] = 0;
                } else if(weight[i-1]> w){
                    t[i][w] = t[i-1][w];
                } else {
                    t[i][w] = Math.max(price[i-1] + t[i-1][w-weight[i-1]], t[i-1][w]);
                }

            }
        }

        return t[weight.length][capacity];

    }
}
