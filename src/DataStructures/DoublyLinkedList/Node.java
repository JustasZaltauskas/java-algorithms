package DataStructures.DoublyLinkedList;

class Node<T> {
    Node<T> prev;
    Node<T> next;
    T val;
  
    public Node(T val) {
      this.val = val;
    }
  
    public String toString() {
      return val.toString();
    }
  }