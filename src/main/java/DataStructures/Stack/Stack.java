package DataStructures.Stack;

import DataStructures.MiniCollection;
import DataStructures.LinkedList.LinkedList;

import java.util.Collection;

public class Stack<E extends Comparable<E>> implements MiniCollection<E> {
    private LinkedList list;

    Stack() {
        list = new LinkedList<E>();
    }

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        return (E) list.removeLast();
    }

    public E peek() {
        return (E) list.peekLast();
    };

    public int search(E e) {
      int index = list.indexOf(e);
      return index < 0 ? index : index + 1;
    };

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(E e) {
        push(e);
    }

    @Override
    public void addAll(Collection<E> c) {
        list.addAll(c);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }
}
