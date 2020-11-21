package tree;

import java.util.HashMap;
import java.util.Map;
//https://www.geeksforgeeks.org/reverse-tree-path/
public class ReverseTreePath {

    public static int position = 0;

    public static void main(String args[]){

        TreeNode bstRoot = new TreeNode(7);
        bstRoot.left = new TreeNode(6);
        bstRoot.right = new TreeNode(5);
        bstRoot.left.left = new TreeNode(4);
        bstRoot.left.right = new TreeNode(3);
        bstRoot.right.left = new TreeNode(2);
        bstRoot.right.right = new TreeNode(1);
        ReverseTreePath reverseTreePath = new ReverseTreePath();
        //TreeNode r = convertBSTToMinHeap.convertBSTToMinHeap(bstRoot);
        BST bst = new BST();
        bst.inorder(bstRoot);
        System.out.println("RESULT");
        bst.inorder(reverseTreePath.reversePath(bstRoot, bstRoot.left.left));

    }


    public TreeNode reversePath(TreeNode root, TreeNode target){
        Map<Integer, Integer> levelToKey = new HashMap<>();
        return reversePathUtil(root,target, levelToKey,0);
    }

    public TreeNode reversePathUtil(TreeNode root, TreeNode target, Map<Integer, Integer> levelToKey, int level){

        if(root == null)
            return root;

        if(root.val == target.val){
            levelToKey.put(level, root.val);
            Integer toReplace = levelToKey.get(position);
            position++;
            root.val = toReplace;
            return root;
        }


        levelToKey.put(level, root.val);
        TreeNode right=null, left = null;
        left = reversePathUtil(root.left, target, levelToKey, level+1);
        if(left == null){
            right = reversePathUtil(root.right, target, levelToKey, level+1);
        }

        if(left != null || right != null){
            root.val = levelToKey.get(position);
            position++;
            return left == null? right : left;
        }

        return null;




    }
}
