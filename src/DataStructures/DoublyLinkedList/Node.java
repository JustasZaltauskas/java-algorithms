package DataStructures.DoublyLinkedList;

public class Node<T> {
    public Node<T> prev;
    public Node<T> next;
    T val;
  
    public Node(T val) {
      this.val = val;
    }
  
    public String toString() {
      return val.toString();
    }
  }