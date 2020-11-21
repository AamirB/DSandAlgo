package tree;

public class TreeUtils {


    public static void printInorder(TreeNode root){

        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(" " +root.val);
        printInorder(root.right);
    }


    public static void printInorder(TreeNodeWithSuccessor root){

        if(root == null)
            return;

        printInorder(root.left);
        if(root.next != null)
        System.out.print(" [" +root.val +" next "+root.next.val+"]");
        else
            System.out.print(" [" +root.val +" next "+ null+"]");
        printInorder(root.right);
    }
}
