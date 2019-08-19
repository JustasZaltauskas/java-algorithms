package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static List<Integer> travelRecursive(Node<Integer> root) {
        List<Integer> res = new ArrayList();
        travelRecursiveHelper(root, res);
        return res;
    }

    private static void travelRecursiveHelper(Node<Integer> root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        travelRecursiveHelper(root.left, res);
        travelRecursiveHelper(root.right, res);
    }

    public static List<Integer> travelIterative(Node<Integer> root) {
        List<Integer> res = new ArrayList();
        Stack<Node<Integer>> stack = new Stack();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return res;
    }
}
