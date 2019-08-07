package DataStructures;

import java.util.Collection;

public interface MiniCollection<E> {
    boolean isEmpty();

    int size();

    boolean add(E e);

    boolean addAll(Collection<E> c);
}
