package DataStructures.Queue;

import DataStructures.LinkedList.LinkedList;

import java.util.Collection;

public class LinkedQueue<E extends Comparable<E>> implements Queue<E> {
    private LinkedList<E> list;

    public LinkedQueue() {
        list = new LinkedList<E>();
    }

    @Override
    public void add(E e) {
        list.addFirst(e);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove() {
        return list.remove();
    }

    @Override
    public E peek() {
        return list.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void addAll(Collection<E> c) {
        list.addAll(c);
    }
}
