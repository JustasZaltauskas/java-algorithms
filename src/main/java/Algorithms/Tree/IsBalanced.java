package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

// https://leetcode.com/problems/balanced-binary-tree/
public class IsBalanced {
    // Top-down approach
    // Time - O(NlogN), Space O(N)
    public static boolean isBalanced(Node root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    private static int getHeight(Node root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // Bottom-up approach
    // Time - O(N), Space O(N)
    public static boolean isBalancedDFS(Node root) {
        if (root == null) return true;
        return getHeight(root) != -1;
    }

    // -1 - unbalanced tree, >= 0 - balanced tree
    private int getHeightDFS(Node root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(rightHeight - leftHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
