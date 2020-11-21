package tree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleBinaryTree {



    public static void main(String args[]){
        AllPossibleBinaryTree treeExe = new AllPossibleBinaryTree();

        List<TreeNode> tree = treeExe.constructAllTreeFromPreOrder(new int[]{4,5,7});
        for(int i=0;i<tree.size();i++){
            System.out.println();
            treeExe.printInorder(tree.get(i));
        }
    }



    private List<TreeNode> constructAllTreeFromPreOrder(int[] pre){
        return constructAllTreeFromPreOrder(pre,0,pre.length-1);
    }


    private List<TreeNode> constructAllTreeFromPreOrder(int[] arr, int start, int end){

        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(start>end){
             trees.add(null);
            return trees;
        }



        for(int i= start;i<=end;i++){
            List<TreeNode> left = constructAllTreeFromPreOrder(arr,start,i-1);
            List<TreeNode> right = constructAllTreeFromPreOrder(arr,i+1,end);


            for(int j=0;j<left.size();j++){

                for(int k=0;k<right.size();k++){
                    TreeNode root = new TreeNode(arr[i]);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    trees.add(root);
                }
            }

        }
        return trees;
    }



    public void printInorder(TreeNode root){

        if(root == null)
            return;
        System.out.print(" " +root.val);
        printInorder(root.left);

        printInorder(root.right);
    }

}
