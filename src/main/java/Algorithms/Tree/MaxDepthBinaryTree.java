package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.Stack;

// https://leetcode.com/problems/maximum-depth-of-binary-tree
public class MaxDepthBinaryTree {
    public static int maxDepth(Node root) {
        return helper(root, 0);
    }

    private static int helper(Node root, int max) {
        if (root == null) {
            return max;
        }

        max++;
        int leftMax = helper(root.left, max);
        int rightMax = helper(root.right, max);

        return Math.max(leftMax, rightMax);
    }

    public static int maxDepthIterative(Node root) {
        Stack<Node> stack = new Stack();
        Stack<Integer> maxStack = new Stack();
        int max = 0;
        stack.push(root);
        maxStack.push(0);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int lastMax = maxStack.pop();

            if (node != null) {
                max = Math.max(max, ++lastMax);
                maxStack.push(lastMax);
                maxStack.push(lastMax);
                stack.push(node.left);
                stack.push(node.right);
            }
        }

        return max;
    }
}
