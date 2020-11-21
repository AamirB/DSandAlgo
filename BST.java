package tree;

public class BST {


    TreeNode root ;


//
//    public BST(){
//        root = null;
//    }

    public void insertRec( int key){
         root = insert(root, key);
    }

    public void inordeRecr(){
        inorder(root);
    }

    public TreeNode insert(TreeNode root, int key){

          if(root == null){
               root = new TreeNode(key);
               return root;
          }


          if(root.val > key){
              root.left = insert(root.left, key);
          } else {
              root.right = insert(root.right, key);
          }

          return root;

    }


    public void inorder(TreeNode root){

        if(root == null)
            return;

        inorder(root.left);

        System.out.print(" " +root.val);
        inorder(root.right);
    }

    public void preOrder(TreeNode root){

        if(root == null)
            return;
        System.out.print(" " +root.val);
        preOrder(root.left);


        preOrder(root.right);
    }

    public boolean search(int key){
        return search(root, key);
    }

    public boolean search(TreeNode root, int key){

        if(root == null){
            System.out.println("Key "+ key + " is not present");
            return false;
        }


        if(root.val == key){
            System.out.println("Key "+ key + " is present");
            return true;

        }

        if(root.val> key){
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }


    public void deleteRec(int key){
        delete(root, key);
    }


    public TreeNode delete(TreeNode root, int key){

        if(root == null)
            return root;

        if(root.val> key){
            return delete(root.left, key);
        } else if(root.val<key){
            return delete(root.right, key);
        } else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            root.val = minValue(root.right);
            root.right = delete(root.right, root.val);
        }
        return root;
    }


    public int minValue(TreeNode root){

        Integer min = null;
        while(root != null){
            min = root.val;
            root = root.left;
        }
        return min;
    }







    public static void main(String args[]){
        BST bst = new BST();

        bst.insertRec( 50);
        bst.insertRec( 30);
        bst.insertRec( 20);
        bst.insertRec( 40);
        bst.insertRec( 70);
        bst.insertRec( 60);
        bst.insertRec( 80);

        bst.inordeRecr();
        System.out.println(bst.search(70));
        bst.deleteRec( 70);
        System.out.println(bst.search(70));
        bst.deleteRec( 30);
        bst.inordeRecr();
    }


}
