package tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToMinHeap {


    public static int indexNew = 0;
    public static void main(String args[]){

        TreeNode bstRoot = new TreeNode(4);
        bstRoot.left = new TreeNode(2);
        bstRoot.right = new TreeNode(6);
        bstRoot.left.left = new TreeNode(1);
        bstRoot.left.right = new TreeNode(3);
        bstRoot.right.left = new TreeNode(5);
        bstRoot.right.right = new TreeNode(7);
        ConvertBSTToMinHeap convertBSTToMinHeap = new ConvertBSTToMinHeap();
        TreeNode r = convertBSTToMinHeap.convertBSTToMinHeap(bstRoot);
        BST bst = new BST();
        bst.preOrder(r);
    }


    public TreeNode convertBSTToMinHeap(TreeNode bstRoot){



        if(bstRoot == null)
            return bstRoot;

        List<Integer> inorderTraversal = new ArrayList<>();
        getInorderTraversal(bstRoot,inorderTraversal );
        System.out.println("Inorder traversal "+ inorderTraversal);

        return convertToHeapFromInorderTraversal(inorderTraversal, 0);
        //return null;

    }

    public TreeNode convertToHeapFromInorderTraversal(List<Integer> inorderTraversal, Integer index){
                if(indexNew>= inorderTraversal.size()){
                    return null;
                }
                TreeNode root = new TreeNode(inorderTraversal.get(indexNew++));

                root.left = convertToHeapFromInorderTraversal(inorderTraversal,indexNew);

                root.right = convertToHeapFromInorderTraversal(inorderTraversal,indexNew);

                return root;
    }

    public void getInorderTraversal(TreeNode root, List<Integer> inorderTraversal){


        if(root == null){
            return;
        }
        getInorderTraversal(root.left, inorderTraversal);
        inorderTraversal.add(root.val);
        getInorderTraversal(root.right, inorderTraversal);
    }
}
