package DataStructures.DoublyLinkedList;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

class DoublyLinkedList<T extends Comparable<T>> {
  Node<T> head;

  public void add(T val) {
    Node<T> node = new Node<>(val);

    if (head == null) {
      head = node;
    } else {
      Node<T> current = head;

      while (current.next != null) {
        current = current.next;
      }

      current.next = node;
      node.prev = current;
   }
  }

  public void addFirst(T val) {
    Node<T> node = new Node<>(val);
    
    if (head == null) {
      add(val);
    } else {
      node.next = head;
      head = node;
    }
  }

  public String toString() {
    Node<T> node = head;
    String list = "";

    while (node != null) {
      list += node.val.toString() + " ";
      node = node.next;
    }

    return list;
  }

  public void addAll(Collection<T> list) {
    for (T val : list) {
      add(val);
    }
  }

  public boolean delete(Node<T> node) {
    if (head == null) {
      return false;
    }

    if (node == head) {
      head = head.next;
    }

    if (node.prev != null) {
      node.prev.next = node.next;
    }

    if (node.next != null) {
      node.next.prev = node.prev;
    }

    return true;
  }

  public boolean delete(int n) {
    int i = 0;
    Node<T> current = head;

    while (i != n && current != null) {
      current = current.next;
      i++;
    }

    if (i == n) {
      return delete(current);
    } else {
      return false;
    }
  }

  public void deleteAll(T val) {
    Node<T> cur = head;

    while (cur != null) {
      if (cur.val.equals(val)) {
        delete(cur);
      }

      cur = cur.next;
    }
  }

  public void insertSorted(T val) {
    if (head == null) {
      add(val);
      return;
    }

    Node<T> node = new Node<>(val);
    Node<T> cur = head;
  
    if (head.val.compareTo(val) > 0) {
      head.prev = node;
      node.next = head;
      head = node;
    } else {
      while (cur.next != null && cur.next.val.compareTo(val) < 0) {
        cur = cur.next;
      }

      if (cur.next == null) {
        cur.next = node;
        node.prev = cur;
      } else {
        node.next = cur.next;
        cur.next = node;
        node.prev = cur;
        node.next.prev = node;
      }
    }
  }

  public void deleteDuplicatesSorted() {
    if (head == null) {
      return;
    }

    Node<T> cur = head;

    while (cur != null) {
      if (cur.prev != null && cur.prev.val.equals(cur.val)) {
        delete(cur);
      }

      cur = cur.next;
    }
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void deleteDuplicates() {
    if (isEmpty()) {
      return;
    }

    Set<T> found = new HashSet<>();
    Node<T> cur = head;

    while (cur != null) {
      if (found.contains(cur.val)) {
        delete(cur);
      } else {
        found.add(cur.val);
      }

      cur = cur.next;
    }
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    List<Integer> arr = Arrays.asList(new Integer[]{1, 2, 3});
    list.addAll(arr);
    System.out.println(list);
  }
}