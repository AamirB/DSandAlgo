package tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertTreeNodeToSumSuccPred {


    private static int index = 0;

    public static void main(String args[]){
        ConvertTreeNodeToSumSuccPred s = new ConvertTreeNodeToSumSuccPred();
        TreeNode root = new TreeNode(1);       //         1
        root.left = new TreeNode(2);        //       /   \
        root.right = new TreeNode(3);       //     2      3
        root.left.left = new TreeNode(4);  //    /  \  /   \
        root.left.right = new TreeNode(5); //   4   5  6   7
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        s.ConvertTreeNodeToSumSuccPred(root);
        s.printInorder(root);
    }



    public TreeNode ConvertTreeNodeToSumSuccPred(TreeNode root){
        List<Integer> s = getInOrderTraversal(root);
         convert(root,s);
         return root;
    }

    public void printInorder(TreeNode root){

        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(" " +root.val);
        printInorder(root.right);
    }


    private void convert(TreeNode root, List<Integer> s){



        if(root.left != null)
            convert(root.left, s);

            root.val = getSum(s, index++);

            if (root.right != null)
                convert(root.right, s);




    }


    private int getSum(List<Integer> s,int index){
        int c = 0;
        if(index>0){
            c = c + s.get(index-1);
        }

        if(index<s.size()-1){
            c = c + s.get(index+1);
        }
        return c;
    }


    private List<Integer> getInOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
         getInOrderTraversal(root,res);
         return res;
    }

    public void getInOrderTraversal(TreeNode root, List<Integer> res){

        if(root == null){
            return ;
        }
        getInOrderTraversal(root.left, res);
        res.add(root.val);
        getInOrderTraversal(root.right,res);
       // return res;

    }
}
