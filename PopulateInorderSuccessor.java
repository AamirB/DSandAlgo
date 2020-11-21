package tree;

public class PopulateInorderSuccessor {

    //private static TreeNodeWithSuccessor prev= null;

    public static void main(String args[]){
        PopulateInorderSuccessor s = new PopulateInorderSuccessor();
        TreeNodeWithSuccessor root = new TreeNodeWithSuccessor(10);
        root.left = new TreeNodeWithSuccessor(8);
        root.right = new TreeNodeWithSuccessor(12);
        root.left.left = new TreeNodeWithSuccessor(3);
        TreeNodeWithSuccessor prev = null;
        s.populate(root,prev);
        TreeUtils.printInorder(root);
    }


    public void populate(TreeNodeWithSuccessor root,TreeNodeWithSuccessor prev){

        if(root != null) {
//            return ;
//        }
            populate(root.right, prev);
            root.next = prev;
            prev = root;
            populate(root.left, prev);
        }
    }

}
