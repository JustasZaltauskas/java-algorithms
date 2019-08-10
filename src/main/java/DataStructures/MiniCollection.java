package DataStructures;

import java.util.Collection;

public interface MiniCollection<E> {
    boolean isEmpty();

    int size();

    void add(E e);

    void addAll(Collection<E> c);

    boolean remove(Object o);
}
