public class CountSubstringKTimes {


    public static void main(String args[]) {

        String str = "3123231";
        char ch = '3';
        int k =2;

        char[] str1 = str.toCharArray();

        int left=0;
        int right =0;

        int count =0;
        int res =0;


       while(right<str1.length ){


          while(right <str1.length && count<=k) {

              if(str1[right]==ch){
                  count++;
              }
              if(count == k){
                  res++;
              }

              if(count>k){
                    break;
              }
              right++;
          }


          while(left < str1.length && count > k){
              if(str1[left]==ch){
                  count--;
              }
              if(count == k){
                  res++;
              }
              left++;
          }
       }
       System.out.println("Results "+ res);


    }
}
