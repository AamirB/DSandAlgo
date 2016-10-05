package dp;

public class MatrixMultiplicationChain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4};
        int size = arr.length;
 
        System.out.println("Minimum number of multiplications is "+
                           MatrixChainOrder(arr, size));
	}

	private static int MatrixChainOrder(int[] arr, int size) {
		
		int [][]dp=new int[size][size];
		
		 for (int i = 1; i < size; i++){
	            dp[i][i] = 0;
	}
		
		for(int l=2;l<size;l++){
			for(int i=1;i<size-l+1;i++){
				int j=i+l-1;
				if(i==j)
					continue;
					dp[i][j]=Integer.MAX_VALUE;
				
				for(int k=i;k<j;k++){
					   // q = cost/scalar multiplications
                    int q = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    if (q < dp[i][j])
                        dp[i][j] = q;
				}
			}
		}
		
		return dp[1][size-1];
	}

}
