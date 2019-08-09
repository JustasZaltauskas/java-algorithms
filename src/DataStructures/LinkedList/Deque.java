package DataStructures.LinkedList;

import DataStructures.Queue.Queue;

public interface Deque<E> extends Queue<E> {
    void addFirst(E e);

    void addLast(E e);

    E removeFirst();

    E removeLast();

    E peekFirst(E e);

    E peekLast(E e);
}
