package dp;

public class LPallSubseq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println("The lnegth of the lps is "+ lps(seq));
	}



    public static int lps(String s) {
        int n=s.length();
        
        int [][] dp=new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        
        for(int l=2;l<=n;l++){
            
            for(int i=0;i<n-l+1;i++){
                
                int j=i+l-1;
                if(s.charAt(i)==s.charAt(j)&&l==2){
                    dp[i][j]=2;
                }else
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
            
        }
        int len=dp[0][n-1];
        StringBuilder res=new StringBuilder(len);
        
        getString(dp);
        return len;
    
}



	private static void getString(int[][] dp) {
		UtilityClass.printtable(dp);
	}
}