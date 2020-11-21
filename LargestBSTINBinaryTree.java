package tree;


///https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/
public class LargestBSTINBinaryTree {




    class BstInfo {

       int max;
       int min;
       boolean isBst;
       int size;

        BstInfo(int max, int min, boolean isBst, int size){
            this.max = max;
            this.min = min;
            this.isBst = isBst;
            this.size = size;
        }

    }



    public BstInfo largestBst(TreeNode root){

        if(root == null){
             return new BstInfo(Integer.MIN_VALUE, Integer.MIN_VALUE, true, 0);
        }

        if(root.left == null && root.right == null){
            return new BstInfo(root.val, root.val, true, 1);
        }


        BstInfo left = largestBst(root.left);
        BstInfo right = largestBst(root.right);

        if( left.isBst && right.isBst && left.max < root.val && right.min > root.val) {
                 return new BstInfo(left.min, root.val, true, 1 + +left.size + right.size);
        }

        return new BstInfo(0,0,false, Math.max(left.size, right.size));

    }
}
