import Structures.BinaryTree
import spock.lang.Specification

/**
 * Created by MikeS on 6/4/18.
 */
class BinaryTreeTest extends Specification {
    def "Test populate BST"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        when:
        binaryTree.insert(3)
        binaryTree.insert(5)
        binaryTree.insert(1)
        then:
        binaryTree.maxDepth() == 2
        binaryTree.getRoot().getItem() == 3;
        binaryTree.getRoot().getLeft().getItem() == 1;
        binaryTree.getRoot().getRight().getItem() == 5;
        binaryTree.getRoot().getLeft().getRight() == null;
        binaryTree.getRoot().getLeft().getLeft() == null;
        binaryTree.getRoot().getRight().getLeft() == null;
        binaryTree.getRoot().getRight().getLeft() == null;
        binaryTree.size() == 3
    }
}
