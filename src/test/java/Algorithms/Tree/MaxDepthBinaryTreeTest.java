package Algorithms.Tree;

import DataStructures.BinaryTree.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxDepthBinaryTreeTest {
    Node root;
    int expected = 4;

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
    public void recursive() {
        assertEquals("Wrong binary tree depth", expected, MaxDepthBinaryTree.recursive(root));
    }

    @Test
    public void dfs() {
        assertEquals("Wrong binary tree depth", expected, MaxDepthBinaryTree.dfs(root));
    }
    @Test
    public void bfs() {
        assertEquals("Wrong binary tree depth", expected, MaxDepthBinaryTree.bfs(root));
    }
}
