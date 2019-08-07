package DataStructures.LinkedList;

import DataStructures.MiniCollection;

import java.util.Arrays;
import java.util.Collection;
import java.lang.Comparable;

public class LinkedList<E extends Comparable<E>> implements MiniCollection<E> {
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

    public boolean add(E x) {
      Node<E> node = new Node(x, null);
  
      if (this.head == null) {
        this.head = node;
        this.tail = this.head;
      } else {
        this.tail.next = node;
        this.tail = this.tail.next;
      }

      size++;
      return true;
    }

    public boolean isEmpty() {
      return head == null;
    }

    public E peek() {
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

    public boolean addAll(Collection<E> collection) {
        for (E el : collection) {
          add(el);
          size++;
        }

        return true;
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
      LinkedList<Integer> list2 = new LinkedList<>();
      list.addAll(Arrays.asList(new Integer[] { 3, 6, 9, 15, 30 }));
      list2.addAll(Arrays.asList(new Integer[] { 10, 15, 30 })); 
    }
  }
  