package dp;

public class UtilityClass {
	
	
	public static void printtable(int [][] table){
		
		System.out.println("Printing Table");
		for(int i=0;i<table.length;i++){
			System.out.println();
			for(int j=0;j<table[0].length;j++){
				System.out.print(table[i][j]+" ");
			}
		}
		
	}

}
