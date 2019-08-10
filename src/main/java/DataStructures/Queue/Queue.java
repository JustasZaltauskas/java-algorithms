package DataStructures.Queue;

import DataStructures.MiniCollection;

public interface Queue<E> extends MiniCollection<E> {
    E remove();

    E peek();
}
