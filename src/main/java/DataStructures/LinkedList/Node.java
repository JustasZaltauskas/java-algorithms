package DataStructures.LinkedList;

public class Node<E extends Comparable<E>> {
  public E val;
  public Node<E> next;

  public Node(E val) {
    this.val = val;
  }

  public Node(E val, Node<E> next) {
    this.val = val;
    this.next = next;
  }

  public String toString() {
    return this.val.toString();
  }
}
