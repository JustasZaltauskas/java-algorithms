package Algorithms.Tree;

import DataStructures.BinaryTree.Node;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTree {
    public Node buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0) return null;
        Map<Integer, Integer> inMap = new HashMap();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1, 0, inMap);
    }

    private Node buildTree(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, Map<Integer, Integer> inMap)  {
        if (inStart > inEnd || preStart >= preorder.length) return null;
        Node root = new Node(preorder[preStart++]);

        int inIdx = inMap.get(root.val);

        root.left = buildTree(preorder, inorder, inStart, inIdx - 1, preStart, inMap);
        root.right = buildTree(preorder, inorder, inIdx + 1, inEnd, preStart + (inIdx - inStart), inMap);

        return root;
    };
}
