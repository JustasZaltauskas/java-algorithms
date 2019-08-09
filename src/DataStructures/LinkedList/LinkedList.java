package DataStructures.LinkedList;

import java.util.Arrays;
import java.util.Collection;
import java.lang.Comparable;

public class LinkedList<E extends Comparable<E>> implements Deque<E> {
    Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Collection<E> c) {
        addAll(c);
    }


    public boolean isEmpty() {
        return head == null;
    }

    public E peekFirst() {
        return head == null ? null : head.val;
    }

    public E peekLast() {
        return tail == null ? null : tail.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        Node<E> node = new Node(e, null);

        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }

        size++;
    }


    @Override
    public void addAll(Collection<E> c) {
        for (E el : c) {
            add(el);
            size++;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, null);
        newNode.next = head;
        head = newNode;

        if (head.next == null) {
            tail = head;
        }

        size++;
    }

    @Override
    public void addLast(E e) {
        add(e);
    }

    @Override
    public E removeFirst() {
        return remove(head.val) ? head.val : null;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node current = head;

        while (current.next != tail) {
            current = current.next;
        }

        current.next = null;
        tail = current;

        return tail.val;
    }

    @Override
    public E peekFirst(E e) {
        return peek();
    }

    @Override
    public E peekLast(E e) {
        return tail.val;
    }

    public boolean remove(Object o) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            if (current.equals(o)) {
                if (prev == null) {
                    head = head.next;
                } else if (current.next == null) {
                    tail = prev;
                    tail.next = null;
                } else {
                    prev = current.next;
                }

                return true;
            }

            prev = current;
            current = current.next;
        }

        return false;
    }

    public String toString() {
        String list = "";
        Node<E> cur = this.head;

        while (cur != null) {
            list = list.concat(cur.val.toString().concat(" "));
            cur = cur.next;
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(new Integer[]{3, 6, 9, 15, 30}));
    }

    @Override
    public E remove() {
        E headVal = peekFirst();
        return remove(headVal) ? headVal : null;
    }

    @Override
    public E peek() {
        return head.val;
    }
}
  