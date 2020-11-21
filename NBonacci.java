public class NBonacci {


    public static void main(String args[]) {


        int N = 3;
        int M = 8;


        int fib[]=new int[M];
        fib[0]=0;
        fib[1]=0;
        fib[2]=1;

        for(int i=3;i<M;i++) {
            fib[i]= fib[i-1]+ fib[i-2];
        }

        for(int i=1;i<M;i++){
            fib[i]=fib[i-1]+fib[i];
        }

        int res[]=new int[M];
        res[0]=0;
        res[1]=0;
        res[2]=1;
        res[3]=1;
       // res[4]=2;
        for(int i=N+1;i<M;i++) {
                res[i]= res[i-1]  - fib[i-N-1];
        }

        for(int i=0;i<M;i++){
            System.out.println(res[i] + " ");
        }




    }
}
