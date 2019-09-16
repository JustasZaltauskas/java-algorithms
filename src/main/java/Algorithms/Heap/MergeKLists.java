package Algorithms.Heap;

import DataStructures.LinkedList.Node;

// https://leetcode.com/problems/merge-k-sorted-lists
import java.util.PriorityQueue;

public class MergeKLists {
    public static Node merge(Node[] lists) {
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> a.val.compareTo(b.val));
        for (Node node : lists) if (node != null) q.add(node);
        Node head = null;
        Node tail = null;

        while (!q.isEmpty()) {
            Node min = q.remove();
            if (head == null) head = tail = min;
            else {
                tail.next = min;
                tail = tail.next;
            }
            if (min.next != null) q.add(min.next);
        }

        return head;
    }
}
