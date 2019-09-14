package Algorithms.LinkedList;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode mergeRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeRecursive(l1, l2.next);
            return l2;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode node = null;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null) {
            boolean initializeHead = node == null;

            if (p2 == null || (p1 != null && p1.val < p2.val)) {
                node = addNode(node, p1);
                p1 = p1.next;
            } else {
                node = addNode(node, p2);
                p2 = p2.next;
            }

            if (initializeHead) head = node;
        }

        return head;
    }

    private ListNode addNode(ListNode node, ListNode newNode) {
        if (node == null) {
            node = new ListNode(newNode.val);
        } else {
            node.next = new ListNode(newNode.val);
            node = node.next;
        }

        node.next = null;
        return node;
    }
}
