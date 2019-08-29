package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/maximum-depth-of-binary-tree
public class MaxDepthBinaryTree {
    public static int recursive(Node root) {
        return root == null ? 0 : 1 + Math.max(recursive(root.left), recursive(root.right));
    }

    public static int dfs(Node root) {
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

                if (node.left != null) {
                    maxStack.push(lastMax);
                    stack.push(node.left);
                }
                if (node.right != null) {
                    maxStack.push(lastMax);
                    stack.push(node.right);
                }
            }
        }

        return max;
    }

    public static int bfs(Node root) {
        if (root == null) return 0;
        Queue<Node> Q = new LinkedList<>();
        int max = 0;
        Q.add(root);

        while (!Q.isEmpty()) {
            Node node;
            int n = Q.size();
            max++;

            for (int i = 0; i < n; i++) {
                node = Q.remove();
                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }
        }

        return max;
    }
}
