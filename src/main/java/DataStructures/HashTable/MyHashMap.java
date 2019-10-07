package DataStructures.HashTable;

// https://leetcode.com/problems/design-hashmap/
// Hash Table implementation, collisions are resolved using linked list
public class MyHashMap {
    ListNode[] nodes;
    public MyHashMap() {
        nodes = new ListNode[1000000];
    }

    public void put(int key, int value) {
        int idx = getIndex(key);

        if (nodes[idx] == null) {
            nodes[idx] = new ListNode(key, value);
        } else {
            ListNode node = nodes[idx];
            while (node.next != null && node.key != key) node = node.next;
            if (node.key == key) {
                node.val = value;
            } else {
                node.next = new ListNode(key, value);
            }
        }
    }

    public int get(int key) {
        ListNode node = nodes[getIndex(key)];
        while (node != null && node.key != key) node = node.next;
        return node == null ? -1 : node.val;
    }

    public void remove(int key) {
        int idx = getIndex(key);
        ListNode node = nodes[idx];

        if (node == null) return;
        if (node.key == key) nodes[idx] = node.next;
        else {
            ListNode prev = findPreviousNode(node, key);
            if (prev != null) prev.next = prev.next.next;
        }
    }

    public ListNode findPreviousNode(ListNode node, int key) {
        if (node == null) return null;
        ListNode prev = null;

        while (node.next != null && node.next.key != key) {
            prev = node;
            node = node.next;
        }

        return prev;
    }

    public int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    public static class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}
