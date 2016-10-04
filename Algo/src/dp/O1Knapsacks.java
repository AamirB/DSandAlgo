package dp;

public class O1Knapsacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 {
		        int val[] = new int[]{60, 100, 120};
		    int wt[] = new int[]{10, 20, 30};
		    int  W = 50;
		    int n = val.length;
		    System.out.println(knapSack(W, wt, val, n));
		    }

	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		
		int [][] dp=new int[n+1][w+1];
		
		
	
		//UtilityClass.printtable(dp);
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=w;j++){
				
				if(i==0||j==0){
					dp[i][j]=0;
				}
				else if(wt[i-1]>j){
					dp[i][j]=dp[i-1][j];
				}else{
					dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
				}
			}
		}
		
		return dp[n][w];
	}

}
