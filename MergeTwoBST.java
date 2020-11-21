package tree;


import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/
//https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/

// merged inroder traversal of both BST and then create BST from Inorder traversla guarantees balanced BST
public class MergeTwoBST {


    public static void main(String args[]){

        BST bst = new BST();

        TreeNode bstRoot1 = new TreeNode(100);
        bstRoot1.left = new TreeNode(50);
        bstRoot1.right = new TreeNode(300);
        bstRoot1.left.left = new TreeNode(20);
        bstRoot1.left.right = new TreeNode(70);
        bst.inorder(bstRoot1);
        MergeTwoBST mergeTwoBST = new MergeTwoBST();

        System.out.println();

        TreeNode bstRoot2 = new TreeNode(80);
        bstRoot2.left = new TreeNode(40);
        bstRoot2.right = new TreeNode(120);
        bst.inorder(bstRoot2);
        System.out.println();
        TreeNode merged = mergeTwoBST.mergeBST(bstRoot1, bstRoot2);
        bst.inorder(merged);

    }

    public TreeNode mergeBST(TreeNode bst1, TreeNode bst2){

        if(bst1 == null)
            return bst2;

        if(bst2 == null)
            return bst1;

        List<Integer> mergedInorderTraversal = getMergedInorderTraversal(bst1, bst2);
        return convertToBST(mergedInorderTraversal,0, mergedInorderTraversal.size()-1);
    }


    public TreeNode convertToBST(List<Integer> inorder, int start, int end) {

        if(start>end)
            return null;

        int mid = start + (end-start)/2;
        TreeNode left = convertToBST(inorder,start, mid-1);
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = left;
        root.right = convertToBST(inorder,mid+1, end);
        return root;
    }


    public List<Integer>  getMergedInorderTraversal(TreeNode bst1, TreeNode bst2){


          List<Integer> inorderTraversal1 = new ArrayList<>();
          getInorderTraversal(bst1,inorderTraversal1);
          List<Integer> inorderTraversal2 =   new ArrayList<>();
          getInorderTraversal(bst2,inorderTraversal2);
          return merge(inorderTraversal1, inorderTraversal2);
    }


    public void getInorderTraversal(TreeNode root, List<Integer> inorderTraversal){

        if(root == null)
            return;

        getInorderTraversal(root.left, inorderTraversal);
        inorderTraversal.add(root.val);
        getInorderTraversal(root.right, inorderTraversal);
    }

    public List<Integer> merge(List<Integer> inorderTraversal1, List<Integer> inorderTraversal2){
        List<Integer> merged = new ArrayList<>();

        int i=0; int j= 0;


        while(i<inorderTraversal1.size() && j< inorderTraversal2.size()){

            if(inorderTraversal1.get(i)< inorderTraversal2.get(j)){
                merged.add(inorderTraversal1.get(i++));
            } else {
                merged.add(inorderTraversal2.get(j++));
            }
        }

        while(i<inorderTraversal1.size()) {
            merged.add(inorderTraversal1.get(i++));
        }

        while(j<inorderTraversal2.size()) {
            merged.add(inorderTraversal2.get(j++));
        }


        return merged;

        }


    }




