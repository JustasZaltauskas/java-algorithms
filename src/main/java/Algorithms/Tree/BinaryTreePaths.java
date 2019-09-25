package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {
    public static List<String> find(Node<Integer> root) {
        List<String> res = new LinkedList();
        helper(res, root, "");
        return res;
    }

    private static void helper(List<String> res, Node<Integer> root, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(s);
        } else {
            String newString = s + "->";
            helper(res, root.left, newString);
            helper(res, root.right, newString);
        }
    }
}
