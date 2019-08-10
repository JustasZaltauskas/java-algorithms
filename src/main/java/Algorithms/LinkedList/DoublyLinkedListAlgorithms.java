package Algorithms.LinkedList;

import DataStructures.DoublyLinkedList.Node;

public class DoublyLinkedListAlgorithms {
    public static boolean isEmpty(Node head) {
        return head == null;
    }

    public static Node rotateCounterClockwise(Node head, int n) {
        if (DoublyLinkedListAlgorithms.isEmpty(head)) {
            return head;
        }

        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        if (head == tail) {
            return head;
        }

        for (int i = 0; i < n; i++) {
            tail.next = head;
            head.prev = tail;
            head = head.next;
            tail = tail.next;
            tail.next = null;
        }

        return head;
    }

    public static Node reverse(Node head) {
        Node current = head;

        while (current != null) {
            if (current.next == null) {
                head = current;
            }

            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.prev;
        }

        return head;
    }
}
