package dp;

import java.lang.reflect.Array;

public class UtilityClass {
	
	
	public static <T> void printtable(T[][] array){
		
		System.out.println("Printing Table");
		for(int i=0;i<array.length;i++){
			System.out.println();
			for(int j=0;j<array[0].length;j++){
				System.out.print(array[i][j]+" ");
			}
		}
		
	}
	
	public static void printArray(int [] arr){
		
		System.out.println("Printing Array");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static <T> T[][] get2dtable(Class<? extends T> cls,int r,int c,T value){
	//A<?>[][] array = new A<?>[2][3];	
		 T[][] array = (T[][])Array.newInstance(cls, r, c);
	 
		 for(int i=0;i<r;i++){
			 for(int j=0;j<c;j++){
				 array[i][j]=value;
			 }
		 }
		 return array;
	}

}
