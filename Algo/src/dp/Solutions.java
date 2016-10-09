package dp;


import java.util.Arrays;
import java.util.Scanner;

public class Solutions {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int [] arr1=new int[n];
        // int [] arr2=new int[n];
         int [] arr=new int[n];
         for(int i=0;i<n;i++){
        	 arr[i]=sc.nextInt();
        	 //arr2[i]=arr1[i];
         }
         
        Arrays.fill(arr1,1);
        
        
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                arr1[i]=arr1[i-1]+1;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                arr1[i]=Math.max(arr1[i],arr1[i+1]+1);
            }
        }
        int sum=0;
        for(int i=0;i<n;i++)
            sum=sum+arr1[i];
        
        System.out.println(sum);
    }
}