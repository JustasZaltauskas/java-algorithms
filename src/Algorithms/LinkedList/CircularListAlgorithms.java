package Algorithms.LinkedList;

import DataStructures.LinkedList.Node;

public class CircularListAlgorithms {

    /*
     https://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/
   */
    public static Node[] split(Node pt) {
        if (pt == null) {
            return null;
        }

        Node slowPt = pt;
        Node fastPt = pt;

        while (fastPt.next != pt && fastPt.next.next != pt) {
            slowPt = slowPt.next;
            fastPt = fastPt.next.next;
        }

        // fastPt represents a tail of list
        if (fastPt.next.next == pt) {
            fastPt = fastPt.next;
        }

        fastPt.next = slowPt.next;
        slowPt.next = pt;

        return new Node[]{pt, fastPt.next};
    }

    public static void print(Node head) {
        Node pt = head;

        do {
            System.out.println(pt);
            pt = pt.next;
        } while (pt != head);
    }
}
