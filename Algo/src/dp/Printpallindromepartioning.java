/**
 * 
 */
package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aamir
 *
 */
public class Printpallindromepartioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		partition("aab");

	}
	
	 public static List<List<String>> partition(String s) {
		 int n=s.length();
		 int [][] dp=new int[n][n];
		 
		 
		 List<List<String>> results=new ArrayList<List<String>>();
		 
		 
		 int j;
		 for(int l=1;l<=n;l++){
			 List<String> res=new ArrayList<String>();
			 for(int i=0;i<=n-l;i++){
				
				 j=i+l-1;
				 
				 if(s.charAt(i)==s.charAt(j)){
					 
					 if(l==1||l==2){
						 dp[i][j]=1;
					 }else {
						 dp[i][j]=dp[i+1][j-1];
					 }
					 if(dp[i][j]==1){
						 res.add(s.substring(i,j+1));
						
					 }
					 
				 }else{
					 dp[i][j]=0;
				 }
				 
			 }
			 results.add(res);
		 }
		 System.out.println(results);
		return null;
	        
	    }

}
