package dp;


public class WaysToDecode {

	public static void main(String[] args) {

		String encodemsg = "12345";

		System.out.println(possibleDecodes(encodemsg));
	}

	private static int possibleDecodes(String s) {
		int n=s.length();
			if(n==0||s==null||s.charAt(0)=='0')
				return 0;

			if(n<=1)
				return 1;

			int [] dp=new int[n];
			dp[0]=1;
			if(Integer.parseInt(s.substring(0,2))>26){

				if(s.charAt(1)!='0'){
					dp[1]=2;
				}else{
					dp[1]=1;
				}

			}else{
				dp[1]=2;
			}
    for(int i=2;i<n;i++){
    	
    	if(s.charAt(i)!='0'){
    		dp[i]+=dp[i-1];
    	}
    	int val=Integer.parseInt(s.substring(i-1,i+1));
    	if(val<=26 && val >=10){
            dp[i]+=dp[i-2];
        }
    	
    }
			
return dp[n-1];
		}

	}

