package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.*;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class DistanceK {
    static Map<Integer, Node<Integer>> parents;

    public static List<Integer> find(Node<Integer> root, Node target, int K) {
        List<Integer> res = new LinkedList();
        if (root == null || target == null) return res;

        Queue<Node<Integer>> q = new LinkedList();
        Set<Integer> seen = new HashSet();
        q.add(target);
        parents = new HashMap();
        anotateParents(root, null);

        while (!q.isEmpty() && K >= 0) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node<Integer> node = q.remove();

                if (K == 0) {
                    res.add(node.val);
                } else {
                    Node<Integer> parent = null;
                    if (parents.containsKey(node.val)) parent = parents.get(node.val);
                    if (parent != null && !seen.contains(parent.val)) q.add(parent);
                    if (node.left != null && !seen.contains(node.left.val)) q.add(node.left);
                    if (node.right != null && !seen.contains(node.right.val)) q.add(node.right);
                }

                seen.add(node.val);
            }

            K--;
        }

        return res;
    }

    private static void anotateParents(Node<Integer> node, Node parent) {
        if (node == null) return;
        if (parent != null) parents.put(node.val, parent);
        anotateParents(node.left, node);
        anotateParents(node.right, node);
    }
}
