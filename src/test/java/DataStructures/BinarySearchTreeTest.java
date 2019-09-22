package DataStructures;

import DataStructures.BinaryTree.BinarySearchTree;
import DataStructures.BinaryTree.Node;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void InitiateWithCollectionTest() {
        BinarySearchTree tree = new BinarySearchTree(
                new ArrayList<>() {{
                    add(1);
                    add(2);
                    add(3);
                }}
        );

        assertEquals("Wrong binary search tree head node", 1, tree.peek());
    }

    @Test
    public void SeachTest() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertTrue("Wrong binary search tree search outcome", tree.search(1));
        assertTrue("Wrong binary search tree search outcome", tree.search(2));
        assertTrue("Wrong binary search tree search outcome", tree.search(3));
        assertFalse("Wrong binary search tree search outcome", tree.search(4));
    }

    @Test
    public void DeleteNodeWith2ChildrenTest() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(11);
        tree.insert(20);

        Node node = tree.delete(10);
        assertFalse("Binary search tree node should have been deleted" , tree.search(10));
        assertEquals("Wrong binary search tree node after deletion", 11 , node.val);
        assertEquals("Wrong binary search tree node after deletion", null , node.right.left);
    }

    @Test
    public void DeleteNodeWithNoChildrenTest() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(11);
        tree.insert(20);

        Node node = tree.delete(11);
        assertFalse("Binary search tree node should have been deleted" , tree.search(11));
        assertEquals("Wrong binary search tree node after deletion", 15 , node.right.val);
        assertEquals("Wrong binary search tree node after deletion", null , node.right.left);
    }

    @Test
    public void DeleteNodeWith1ChildrenTest() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(6);
        tree.insert(15);
        tree.insert(11);
        tree.insert(20);

        Node node = tree.delete(5);
        assertFalse("Binary search tree node should have been deleted" , tree.search(5));
        assertEquals("Wrong binary search tree node after deletion", 6 , node.left.val);
    }
}
