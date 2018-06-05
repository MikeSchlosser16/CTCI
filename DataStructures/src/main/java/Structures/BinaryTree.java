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
            root = new TreeNode(item);
            return root;
        }
        if(item < root.item) root.left = insert(root.left, item);
        else root.right = insert(root.right, item);

        return root;
    }

    public TreeNode delete(Integer item){
        return delete(root, item);
    }

    private TreeNode delete(TreeNode node, Integer item){
        if(node == null){
            return null;
        }

        // Node to delete found
        if(item == node.item){
            /* 3 main different cases
                1. Node has no children(just replace node with null in its parent node)
                2. Node has exactly one child(in the parent node, we replace this node with its only child)
                3. A node has two children(requires a tree reorganization)
             */

            // 1
            if(node.left == null && node.right == null){
                return null;
            }
            // 2
            if(node.right == null){
                return node.left;
            }
            if(node.left == null){
                return node.right;
            }
            // 3

            // Find node that will replace the deleted node(we'll use smallest node of node to be deletes right subtree)
            Integer smallestValue = findSmallestValue(node.right);
            // Assign the smallest value to the node to delete, and then delete it from right subtree
            node.item = smallestValue;
            node.right = delete(node.right, smallestValue);

        }
        if(item < node.item){
            return delete(node.left, item);
        } else {
            return delete(node.right, item);
        }
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
