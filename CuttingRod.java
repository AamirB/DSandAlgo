package google.dp;

public class CuttingRod {


    public static void main(String args[]){
        int[] length ={1,2,3,4,5,6,7,8};
        int[] price = {3,5,8,9,10,17,17,20};
        CuttingRod cuttingRod = new CuttingRod();
        int maxProfit = cuttingRod.maxProfit(length, price, 0, length[length.length-1]);
        System.out.println("maxProfit "+ maxProfit);
        System.out.println("maxProfitMemoized "+ cuttingRod.maxProfitMemoized(length, price));
    }


    public int maxProfit(int[] length , int[] price, int index, int remainingLength) {

        if(index >= price.length || remainingLength==0)
            return 0;

        if(length[index]>remainingLength){
            return maxProfit(length,price,index +1 ,remainingLength);
        }

        return Math.max(
                price[index] +maxProfit(length,price,index,remainingLength-length[index]),
                maxProfit(length,price,index +1 ,remainingLength)

		);

    }

    public int maxProfitMemoized(int[] length , int[] price) {

        int maxProfit[][] = new int[price.length+1][length.length+1];

        for(int i=0;i<price.length;i++){
            maxProfit[i][0] = 0;
        }

        for(int i=0;i<price.length;i++){

            for(int j=0;j<length.length;j++){

                if(i==0 || j==0){
                    maxProfit[i][j] =0;
                } else {
                    int max =0;
                    if(j-length[i-1]>=0){
                        int max1 = price[i-1] + maxProfit[i][j-length[j-1]];
                        max = Math.max(max1, maxProfit[i-1][j]);
                        maxProfit[i][j] =max;
                    } else {
                        maxProfit[i][j] =maxProfit[i-1][j];
                    }

                }
            }


        }
        return maxProfit[price.length][length.length];
    }


}
