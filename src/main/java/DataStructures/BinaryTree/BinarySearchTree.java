package DataStructures.BinaryTree;

import java.util.Collection;

public class BinarySearchTree {
    public Node<Integer> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int key) {
        this();
        insert(key);
    }

    public BinarySearchTree(Collection<Integer> c) {
        for (int key : c) insert(key);
    }

    public int peek() {
        return root == null ? null : root.val;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(root, key);
        }
    }

    private void insert(Node<Integer> node, int key) {
        if (node.val >= key) {
            if (node.left == null) node.left = new Node(key);
            else insert(node.left, key);
        } else {
            if (node.right == null) node.right = new Node(key);
            else insert(node.right, key);
        }
    }

    public Node delete(int key) {
        return delete(root, key);
    }

    private Node delete(Node<Integer> node, int key) {
        if (node == null) return node;
        if (node.val > key) {
            node.left = delete(node.left, key);
        } else if (node.val < key){
            node.right = delete(node.right, key);
        } else {
            // If node have only one child, assign it to parent node
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Assign min value from right subtree
            node.val = minValue(node.right);
            // Delete min value on the right subtree
            node.right = delete(node.right, node.val);
        }

        return node;
    }

    private int minValue(Node<Integer> node) {
        if (node.left == null) return node.val;
        return minValue(node.left);
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node<Integer> node, int key) {
        if (node == null) return false;
        if (node.val == key) return true;
        if (node.val > key) return search(node.left, key);
        else return search(node.right, key);
    }

    private Node searchNode(Node<Integer> node, int key) {
        if (node == null || node.val == key) return node;
        if (node.val > key) return searchNode(node.left, key);
        else return searchNode(node.right, key);
    }
}
