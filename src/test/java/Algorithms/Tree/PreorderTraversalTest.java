package Algorithms.Tree;

import DataStructures.BinaryTree.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreorderTraversalTest {
    @Test
    public void TravelRecursive() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        assertEquals("Wrong order or preorder traversal", List.of(1, 2, 4, 5, 3, 6, 7), PreorderTraversal.travelRecursive(root));
        assertEquals("Wrong order or preorder traversal", List.of(1, 2, 4, 5, 3, 6, 7), PreorderTraversal.travelIterative(root));
    }
}
