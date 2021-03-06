package Structures;

/**
 * Created by MikeS on 5/29/18.
 */

/* A binary tree must have the following properties:
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

//BST
public class BinaryTree {

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private TreeNode root;

    public BinaryTree(){
        root = null;
    }

    private static class TreeNode {

        public Integer getItem() {
            return item;
        }

        public void setItem(Integer item) {
            this.item = item;
        }

        Integer item;

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        TreeNode left;

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        TreeNode right;

        public TreeNode(Integer item, TreeNode left, TreeNode right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
        public TreeNode(Integer item){
            this.item = item;
            this.right = null;
            this.left = null;
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
        root = insert(root, item);
    }


    private TreeNode insert(TreeNode root, Integer item){
        if(root == null) {
            root = new TreeNode(item, null, null);
            return root;
        }
        if(item < root.item) root.left = insert(root.left, item);
        else root.right = insert(root.right, item);

        return root;
    }

    public TreeNode delete(Integer item){
        return delete(root, item);
    }

    private TreeNode delete(TreeNode root, Integer item){
        if(root == null){
            return null;
        }

        // Node to delete found
            /* 3 main different cases
                1. Node has no children(just replace node with null in its parent node)
                2. Node has exactly one child(in the parent node, we replace this node with its only child)
                3. A node has two children(requires a tree reorganization)
             */


            if (root == null) return root;

            if (item < root.getItem()) {
                root.setLeft(delete(root.getLeft(), item));
            } else if (item > root.getItem()) {
                root.setRight(delete(root.getRight(), item));
            } else {
                // node with no leaf nodes
                if (root.getLeft() == null && root.getRight() == null) {
                    System.out.println("deleting " + item);
                    return null;
                } else if (root.getLeft() == null) {
                    // node with one node (no left node)
                    System.out.println("deleting " + item);
                    return root.getRight();
                } else if (root.getRight() == null) {
                    // node with one node (no right node)
                    System.out.println("deleting " + item);
                    return root.getLeft();
                } else {
                    /*
                        2 children nodes
                        1 - First find the node reference with given value.
                        2 - Find the minimum/maximum value of the right/left sub tree. (One of them, I am finding min)
                        3 - Replace the node value with the minimum/maximum value.
                        4 - Now delete the minimum/maximum value from the nodes right/left sub tree.
                    */

                    Integer minValue = minValue(root.getRight());
                    root.setItem(minValue);
                    root.setRight(delete(root.getRight(), minValue));
                    System.out.println("deleting " + item);
                }
            }

            return root;
    }

    private Integer findSmallestValue(TreeNode root){
        return root.left == null ? root.item : findSmallestValue(root.left);
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
        if(node.left == null) {
            return node.item;
        } else {
            return minValue(node.left);
        }
    }

    public Integer maxValue(){
        return maxValue(root);
    }

    private Integer maxValue(TreeNode node){
        if(node.right == null) {
            return node.item;
        } else {
            return maxValue(node.right);
        }
    }
    /*
    If the tree is non-empty, then it consists of a root and two subtrees. Print the item in the root and use
      recursion to print the items in the subtrees. This prints all the items on one line of output
      -- In a preorder traversal, the root node of the tree is processed first, then the left subtree is traversed,
            then the right subtree
      -- In a postorder traversal, the left subtree is traversed, then the right subtree, and then the root node
            is processed.
      -- And in an inorder traversal, the left subtree is traversed first, then the root node is processed, then the
            right subtree is traversed
      */


    public static String preOrder(TreeNode root){
        String displayNodes = "";
        if (root != null) {
            displayNodes = displayNodes + root.getItem() + " ";
            displayNodes = displayNodes +
                    preOrder(root.left);
            displayNodes = displayNodes +
                    preOrder(root.right);
        }
        return displayNodes;
    }

    public static String inOrder(TreeNode root){
        String displayNodes = "";
        if(root != null){
            displayNodes = displayNodes + inOrder(root.left);
            displayNodes += root.item + " ";
            displayNodes = displayNodes + inOrder(root.right);
        }
        return displayNodes;
    }

    public static String postOrder(TreeNode root){
        String displayNodes = "";
        if(root != null){
            displayNodes += postOrder(root.left);
            displayNodes += postOrder(root.right);
            displayNodes += root.item + " ";
        }
        return displayNodes;
    }
}
