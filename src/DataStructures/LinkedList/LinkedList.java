package DataStructures.LinkedList;

import DataStructures.MiniCollection;
import DataStructures.Queue.Queue;

import java.util.Arrays;
import java.util.Collection;
import java.lang.Comparable;

public class LinkedList<E extends Comparable<E>> implements MiniCollection<E>, Queue<E> {
    Node<E> head;
    private Node<E> tail;
    private int size = 0;
  
    public LinkedList() {
      this.head = null;
      this.tail = null;
    }

    public LinkedList(Collection<E> collection) {
      addAll(collection);
    }

    public void add(E x) {
      Node<E> node = new Node(x, null);
  
      if (this.head == null) {
        this.head = node;
        this.tail = this.head;
      } else {
        this.tail.next = node;
        this.tail = this.tail.next;
      }

      size++;
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

    public boolean addFirst(E x) {
         final Node<E> newNode = new Node<>(x, null);

         if (!isEmpty()) {
           newNode.next = head;
         }

         head = newNode;
         size++;
         return true;
      }

    public void addAll(Collection<E> collection) {
        for (E el : collection) {
          add(el);
          size++;
        }
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
      list.addAll(Arrays.asList(new Integer[] { 3, 6, 9, 15, 30 }));
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
  