package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal
public class PostorderTraversal {
    public static List<Integer> travel(Node root) {
        LinkedList<Integer> res = new LinkedList();
        if (root == null) return res;
        Stack<Node> stack = new Stack();
        stack.push(root);
        Node<Integer> node;

        while (!stack.isEmpty()) {
            node = stack.pop();
            res.addFirst(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return res;
    }

    public static List<Integer> travelRecursive(Node root) {
        LinkedList<Integer> res = new LinkedList();
        travelRecursive(root, res);
        return res;
    }

    private static void travelRecursive(Node<Integer> root, List<Integer> res) {
        if (root == null) return;
        travelRecursive(root.left, res);
        travelRecursive(root.right, res);
        res.add(root.val);
    }
}
