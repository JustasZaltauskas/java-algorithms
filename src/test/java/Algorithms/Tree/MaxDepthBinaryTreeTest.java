package Algorithms.Tree;

import DataStructures.BinaryTree.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxDepthBinaryTreeTest {
    Node root;

    @Before
    public void before() {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(3);
    }

    @Test
    public void maxDepth() {
        assertEquals("Wrong binary tree depth", 4, MaxDepthBinaryTree.maxDepth(root));
    }

    @Test
    public void maxDepthIterative() {
        assertEquals("Wrong binary tree depth", 4, MaxDepthBinaryTree.maxDepthIterative(root));
    }
}
