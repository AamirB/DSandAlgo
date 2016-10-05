package dp;

public class EggDropPuzzle {

	
	public static void main(String args[]){
		 int n = 2, k = 36;
	        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
	                 " floors is "+eggDrop(n, k));
	}

	private static int eggDrop(int eggs, int floors) {
		int [][] trialsDp=new int[eggs+1][floors+1];
		
		for(int i=1;i<=eggs;i++){
			trialsDp[i][1]=1;
			trialsDp[i][0]=0;
		}
		
		for(int i=1;i<=floors;i++){
			trialsDp[1][i]=i;
			//trialsDp[0][i]=0;
		}
	
		int min;
		
		for(int i=2;i<=eggs;i++){
			for(int j=2;j<=floors;j++){
				trialsDp[i][j]=Integer.MAX_VALUE;
				for(int k=1;k<=j;k++){
				min=1+Math.max(trialsDp[i-1][k-1], trialsDp[i][j-k]);
					if(min<trialsDp[i][j]){
						trialsDp[i][j]=min;
					}
					
				}
			}
		}
		
		
		return trialsDp[eggs][floors];
	}
}
