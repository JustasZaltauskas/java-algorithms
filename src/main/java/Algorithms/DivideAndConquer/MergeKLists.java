package Algorithms.DivideAndConquer;

import DataStructures.LinkedList.Node;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKLists {
    public static Node merge(Node[] lists) {
        if (lists.length <= 0) return null;
        boolean isDone = false;
        Node head = null;
        Node tail = null;
        int minIdx = 0;

        while (!isDone) {
            minIdx = 0;

            for (int i = 0; i < lists.length; i++) {
                Node cur = lists[i];
                if (cur == null) continue;
                if (lists[minIdx] == null) minIdx = i;
                else if (cur.val.compareTo(lists[minIdx].val) < 0) minIdx = i;
            }

            if (lists[minIdx] == null) isDone = true;
            else {
                if (head == null) {
                    head = new Node<E>(lists[minIdx].val);
                    tail = head;
                } else {
                    tail.next = new Node(lists[minIdx].val);
                    tail = tail.next;
                }
                lists[minIdx] = lists[minIdx].next;
            }
        }

        return head;
    }

    public static Node mergeRecursive(Node[] lists) {
        if (lists.length <= 0) return null;
        Node head = null;
        int minIdx = 0;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (lists[minIdx] == null || lists[i].val.compareTo(lists[minIdx].val) < 0) minIdx = i;
        }

        if (lists[minIdx] == null) return null;
        if (head == null) {
            head = lists[minIdx];
        } else {
            head.next = lists[minIdx];
        }
        lists[minIdx] = lists[minIdx].next;
        head.next = mergeRecursive(lists);

        return head;
    }
}
