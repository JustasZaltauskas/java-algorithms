package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

// https://leetcode.com/problems/invert-binary-tree
public class InvertBinaryTree {
    public static <E> Node<E> invertTree(Node<E> root) {
        if (root == null) return null;
        Node<E> temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
