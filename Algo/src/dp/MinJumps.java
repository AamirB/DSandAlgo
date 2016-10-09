package dp;

/**
 * 
 */

/**
 * @author aamir
 *
 */
public class MinJumps {


	public static void main(String[] args) {
		//int arr[] = {1, 3, 6,1,0,9};
		//int arr[] = {3, 2,1,0,4};
		int arr[] = {2, 3, 1,1,4};
		

		minJumps(arr);
		//A = [2,3,1,1,4], return true.

				//A = [3,2,1,0,4], return false.

	}

	private static void minJumps(int[] arr) {
		
		int n=arr.length;
		int []jumps=new int[n];
//		 if (n == 0 || arr[0] == 0)
//		        return false;
//		
		//Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0]=0;
		for(int i=1;i<n;i++){
			jumps[i]=Integer.MAX_VALUE;
			for(int j=0;j<i;j++){

				if(i<=j+arr[j]&&jumps[j]!=Integer.MAX_VALUE){
					jumps[i]=Math.min(jumps[i], jumps[j]+1);
					break;
				}

			}
		}
		//UtilityClass.printArray(jumps);
		//System.out.println(jumps);
		
//		if(jumps[n-1]!=Integer.MAX_VALUE)
//			return jumps[n-1];
//		return -1;
	}

}
