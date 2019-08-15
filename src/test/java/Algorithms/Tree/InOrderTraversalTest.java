package Algorithms.Tree;

import DataStructures.BinaryTree.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InOrderTraversalTest {
    @Test
    public void inOrderTraversal() {
        Node<Integer> node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        assertEquals("Wrong tree order", List.of(4, 2, 5, 1, 6, 3, 7), InOrderTraversal.travelRecursive(node));
        assertEquals("Wrong tree order", List.of(4, 2, 5, 1, 6, 3, 7), InOrderTraversal.travelIterative(node));
    }
}
