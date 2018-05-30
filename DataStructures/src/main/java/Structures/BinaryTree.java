package Structures;

/**
 * Created by MikeS on 5/29/18.
 */

/* A binary tree must have the following properities:
    1. There is exactly one node in the tree which has no parent (root of the tree)
    2. Every other node in the tree has exactly one parent
    3. There can be no loops in a binary tree (it is not possible to follow a chain of pointers starting at the same node and arriving back at the same node)

    Terminology
    1. Root node
    2. Parent node
    3. Child node
    4. Leaf (no children, recoignized by left and right pointers being null)
    5. Subtree (we can consider any non-empty binary tree to be made up of a root node, a left subtree and a right subtree)
        - This is a recursive definition, so no suprise that recusrive subroutines often used to process trees



*/
public class BinaryTree {

    TreeNode root;

    public BinaryTree(){
        root = null;
    }

    private static class TreeNode {
        Integer item;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer item, TreeNode left, TreeNode right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }


    public boolean lookup(Integer item){
        return lookup(root, item);
    }

    private boolean lookup(TreeNode node, Integer item){
        if(node == null){
            return false;
        }
        if(node.item == item){
            return true;
        } else {
           if(item < node.item){
               return lookup(node.left, item);
           } else {
               return lookup(node.right, item);
           }
        }
    }

    public void insert(Integer item){
        insert(root, item);
    }

    private void insert(TreeNode node, Integer item){
        if(root == null){
            node = new TreeNode(item, null, null);
        } else{
            if(item <= node.item){
                insert(node.left, item);
            } else {
                insert(node.right, item);
            }
        }
    }

    public Integer size(){
        return size(root);
    }

    private Integer size(TreeNode root){
        if(root == null) {
            return 0; // Tree empty, contains no nodes
        } else {
            int count = 1; // Account for the root
            count += size(root.left);
            count += size(root.right);
            return count;
        }
    }

    public Integer maxDepth(){
        return maxDepth(root);
    }

    private Integer maxDepth(TreeNode node){
        if(node == null){
            return 0;
        } else {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    public Integer minValue(){
        return minValue(root);
    }

    private Integer minValue(TreeNode node){
        if(root.left == null) {
            return root.item;
        } else {
            return minValue(node.left);
        }
    }

    public Integer maxValue(){
        return maxValue(root);
    }

    private Integer maxValue(TreeNode node){
        if(root.right == null) {
            return root.item;
        } else {
            return minValue(node.right);
        }
    }

    /*If the tree is non-empty, then it consists of a root and two subtrees. Print the item in the root and use
      recursion to print the items in the subtrees. This prints all the items on one line of output
      -- In a preorder traversal, the root node of the tree is processed first, then the left subtree is traversed,
            then the right subtree
      -- In a postorder traversal, the left subtree is traversed, then the right subtree, and then the root node
            is processed.
      -- And in an inorder traversal, the left subtree is traversed first, then the root node is processed, then the
            right subtree is traversed
      */
    static void preorderPrint(TreeNode root){
        if(root != null){
            System.out.println(root.item + " ");
            preorderPrint(root.left);
            preorderPrint(root.right);
        }
    }

    static void inorderPrint(TreeNode root){
        if(root != null){
            preorderPrint(root.left);
            System.out.println(root.item + " ");
            preorderPrint(root.right);
        }
    }

    static void postorderPrint(TreeNode root){
        if(root != null){
            preorderPrint(root.left);
            preorderPrint(root.right);
            System.out.println(root.item + " ");
        }
    }


}
