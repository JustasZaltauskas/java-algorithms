package DataStructures.Queue;

import DataStructures.LinkedList.LinkedList;

import java.util.Collection;

public class LinkedQueue<E extends Comparable<E>> implements Queue<E> {
    private LinkedList<E> list;
    private int size;

    public LinkedQueue() {
        list = new LinkedList<E>();
        size = 0;
    }

    @Override
    public boolean add(E e) {
        return list.addFirst(e);
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(Collection<E> c) {
        list.addAll(c);
        size += c.size();
        return true;
    }
}
