package DataStructures.Queue;

import DataStructures.MiniCollection;

public interface Queue<E> extends MiniCollection<E> {
    boolean add(E e);

    E remove();

    E element();
}
