import java.util.Arrays;
import java.util.Comparator;

public class SortJavaPair {


public static void main(String args[]){


    int[][] interval = {{1,3},{2,6},{8,1},{15,2}};
    int[][] res = new int[4][];
     int[] a= new int[]{1,2};
    Arrays.sort(interval, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1],o2[1]);
        }
    });

    System.out.println(interval);

}



}
