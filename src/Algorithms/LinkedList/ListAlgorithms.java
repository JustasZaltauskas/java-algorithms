package Algorithms.LinkedList;

import DataStructures.LinkedList.LinkedList;
import DataStructures.LinkedList.Node;

public class ListAlgorithms {

    /*
    https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
    */
    public static <E extends Comparable<E>> LinkedList<E> findIntersection(Node<E> head, Node<E> head2) {
        LinkedList intersection = new LinkedList();
        Node p1 = head;
        Node p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.val.compareTo(p2.val) == 0) {
                intersection.add(p1.val);
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.val.compareTo(p2.val) < 0) {
                p1 = p1.next;
            } else if (p1.val.compareTo(p2.val) > 0) {
                p2 = p2.next;
            }
        }

        return intersection;
    }

    /*
    https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
   */
    public static <E extends Comparable<E>> Node<E> findIntersectionRecursive(Node<E> p1, Node<E> p2) {
        if (p1 == null || p2 == null) {
            return null;
        }

        if (p1.val.compareTo(p2.val) < 0) {
            return findIntersectionRecursive(p1.next, p2);
        } else if (p1.val.compareTo(p2.val) > 0) {
            return findIntersectionRecursive(p1, p2.next);
        }

        Node<E> node = new Node(p1.val, null);
        node.next = findIntersectionRecursive(p1.next, p2.next);

        return node;
    }

    public static Node findIntersectionPoint(Node p1, Node p2) {
        if (p1 == null || p2 == null) {
            return null;
        }

        int lengthP1 = getLength(p1);
        int lengthP2 = getLength(p2);
        int lengthDiff = Math.abs(lengthP1 - lengthP2);
        Node pp1 = lengthP1 > lengthP2 ? p1 : p2;
        Node pp2 = lengthP1 > lengthP2 ? p2 : p1;
        int i = 0;

        while (i < lengthDiff) {
            pp1 = pp1.next;
            i++;
        }

        while (pp1 != pp2) {
            pp1 = pp1.next;
            pp2 = pp2.next;
        }

        return pp1;
    }

    public static int getLength(Node p1) {
        Node p = p1;
        int length = 0;

        while (p != null) {
            p = p.next;
            length++;
        }

        return length;
    }

    /*
    https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
    */
    public <E extends Comparable<E>> Node<E> swapNodes(Node<E> head, E x, E y) {
        Node<E> prevX = null;
        Node<E> prevY = null;
        Node<E> nodeX = null;
        Node<E> nodeY = null;
        Node<E> current = head;

        while (current != null) {
            if (current.next != null) {
                if (current.next.val == x) {
                    prevX = current;
                } else if (current.next.val == y) {
                    prevY = current;
                }
            }

            if (current.val == x) {
                nodeX = current;
            } else if (current.val == y) {
                nodeY = current;
            }

            current = current.next;
        }

        if (nodeX == null || nodeY == null) {
            return head;
        }

        if (prevX != null) {
            prevX.next = nodeY;
        } else {
            head = nodeY;
        }

        if (prevY != null) {
            prevY.next = nodeX;
        } else {
            head = nodeX;
        }

        Node<E> temp = nodeX.next;
        nodeX.next = nodeY.next;
        nodeY.next = temp;

        return head;
    }

    /*
    https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
    */
    public static <E extends Comparable<E>> Node<E> pairSwap(Node<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<E> prev = null;
        Node<E> x = head;

        while (x != null && x.next != null) {
            Node<E> y = x.next;

            if (prev == null) {
                prev = x;
                head = y;
            } else {
                prev.next = y;
                prev = x;
            }

            x.next = y.next;
            y.next = x;
            x = x.next;
        }

        return head;
    }

    /*
     https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
     Make even elements go before odd in a linked list
   */
    public static Node<Integer> segregateByParity(Node<Integer> head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node<Integer> current = head;
        Node<Integer> tail = head.next;

        while (tail.next != null) {
            tail = tail.next;
        }

        Node<Integer> oldTail = tail;
        boolean isEndOfList = false;
        Node<Integer> prev = null;

        while (!isEndOfList) {
            if (current == oldTail) {
                isEndOfList = true;
            }

            Node<Integer> next = current.next;

            if (current.val % 2 != 0) {
                if (current == head) {
                    head = next;
                }
                if (prev != null) {
                    prev.next = next;
                }
                current.next = null;
                tail.next = current;
                tail = tail.next;
            } else {
                prev = current;
            }

            current = next;
        }

        return head;
    }

    public static void print(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println();
    }
}
