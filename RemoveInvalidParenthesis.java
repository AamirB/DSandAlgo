package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParenthesis {

    public static void main(String args[]){
        RemoveInvalidParenthesis removeInvalidParenthesis = new RemoveInvalidParenthesis();
        List<String> res = new ArrayList<>();
        String invalidParenthesisString ="()))((";
        removeInvalidParenthesis.removeInvalidParenthesis(invalidParenthesisString,0,res,
                new StringBuilder());
        System.out.println("Possible valid parenthesis"+ res);
//        for(String s: res){
//            System.out.println(s);
//        }
    }

    public void removeInvalidParenthesis(String str, int start, List<String> res, StringBuilder curr){


        if(start>=str.length() && isValidParenthesis(curr.toString())){
            res.add(curr.toString());
        }

        for(int i=start;i<str.length();i++){

           // StringBuilder temp = new StringBuilder(curr).append(str.charAt(i));
            curr.append(str.charAt(i));
            removeInvalidParenthesis(str,i+1, res, curr);
            curr.setLength(curr.length()-1);
        }

    }

    private boolean isValidParenthesis(String s){
        Stack<Character> stack= new Stack();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==')'){

                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != '('){
                    return false;
                }
                stack.pop();

            } else {
                stack.push(s.charAt(i));
            }


        }

        return stack.isEmpty();
    }
}
