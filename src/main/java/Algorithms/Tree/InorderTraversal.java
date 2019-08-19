package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {
    public static List<Integer> travelIterative(Node<Integer> root) {
        Node<Integer> node = root;
        List<Integer> arr = new ArrayList();
        Stack<Node<Integer>> stack = new Stack();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            arr.add(node.val);
            node = node.right;
        }

        return arr;
    }

    public static List<Integer> travelRecursive(Node<Integer> root) {
        List<Integer> arr = new ArrayList();
        travelRecursive(root, arr);
        return arr;
    }

    private static void travelRecursive(Node<Integer> root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        travelRecursive(root.left, arr);
        arr.add(root.val);
        travelRecursive(root.right, arr);
    }
}
