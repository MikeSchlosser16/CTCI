import Structures.BinaryTree
import org.junit.Ignore
import spock.lang.Specification

/**
 * Created by MikeS on 6/4/18.
 */
class BinaryTreeTest extends Specification {
    def "Test insert"(){
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

    def "Test lookup"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        when:
        binaryTree.insert(1)
        binaryTree.insert(16)
        binaryTree.insert(14)
        then:
        binaryTree.lookup(1)
        binaryTree.lookup(16)
        binaryTree.lookup(14)
        !binaryTree.lookup(2)
    }

    @spock.lang.Ignore
    def "Test delete"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(60)
        binaryTree.insert(20)
        binaryTree.insert(70)
        binaryTree.insert(10)
        binaryTree.insert(40)
        binaryTree.insert(30)
        binaryTree.insert(50)

        /*
                60
              /   \
             20   70
            /  \
           10   40
                / \
               30 50
         */
        when:
        binaryTree.delete(70)
        then:
        println(BinaryTree.preOrder(binaryTree.getRoot()))
        binaryTree.size() == 6
        binaryTree.getRoot().getRight() == null
        !binaryTree.lookup(70)
        binaryTree.maxValue() == 60
    }

    def "Test findSmallestValue"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        when:
        binaryTree.insert(4)
        binaryTree.insert(7)
        binaryTree.insert(2)
        then:
        binaryTree.minValue() == 2
    }

    def "Test findMaxValue"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        when:
        binaryTree.insert(4)
        binaryTree.insert(7)
        binaryTree.insert(2)
        then:
        binaryTree.maxValue() == 7
    }

    // In preorder, root -> left subtree -> right subtree
    def "Test preOrder"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        when:
        binaryTree.insert(4)
        binaryTree.insert(11)
        binaryTree.insert(17)
        binaryTree.insert(13)
        binaryTree.insert(5)
        binaryTree.insert(2)
        /*
                4
              /   \
             2     11
                 /    \
                 5    17
                     /
                   13

         */
        then:
        BinaryTree.preOrder(binaryTree.getRoot()) == "4 2 11 5 17 13 "
    }

    // In inorder, we go left -> root -> right
    def "Test inOrder"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        when:
        binaryTree.insert(4)
        binaryTree.insert(11)
        binaryTree.insert(17)
        binaryTree.insert(13)
        binaryTree.insert(5)
        binaryTree.insert(2)
        /*
                4
              /   \
             2     11
                 /    \
                 5    17
                     /
                    13
         */
        then:
        BinaryTree.inOrder(binaryTree.getRoot()) == "2 4 5 11 13 17 "
    }

    @spock.lang.Ignore
    // In postorder, left -> right -> root
    def "Test postOrder"(){
        given:
        BinaryTree binaryTree = new BinaryTree();
        when:
        binaryTree.insert(60)
        binaryTree.insert(20)
        binaryTree.insert(70)
        binaryTree.insert(10)
        binaryTree.insert(40)
        binaryTree.insert(30)
        binaryTree.insert(50)

        /*
                60
              /   \
             20   70
            /  \
           10   40
                / \
               30 50
         */
        then:
        BinaryTree.inOrder(binaryTree.getRoot()) == "10 30 50 40 30 70 60 "
    }
}
