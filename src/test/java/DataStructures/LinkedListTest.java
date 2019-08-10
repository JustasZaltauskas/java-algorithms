package DataStructures;

import DataStructures.LinkedList.LinkedList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void addToList() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");

        assertEquals("Wrong list size", 2, list.size());
        assertEquals("Wrong head element", "A", list.peek());
        assertEquals("Wrong tail element", "B", list.peekLast());
    }

    @Test
    public void initializeListWithCollection() {
        LinkedList list = createList();

        assertEquals("Wrong list size", 5, list.size());
        assertEquals("Wrong head element", 1, list.peek());
        assertEquals("Wrong tail element", 5, list.peekLast());
    }

    @Test
    public void removeHeadElement() {
        LinkedList list = createList();

        list.remove(1);

        assertEquals("Wrong head element", 2, list.peek());
        assertEquals("Wrong list size", 4, list.size());
    }

    @Test
    public void removeFirst() {
        LinkedList list = createList();

        list.removeFirst();

        assertEquals("Wrong head element", 2, list.peek());
        assertEquals("Wrong list size", 4, list.size());
    }

    @Test
    public void peekFirst() {
        LinkedList list = createList();

        assertEquals("Wrong head element", 1, list.peekFirst());
    }

    @Test
    public void removeTailElement() {
        LinkedList list = createList();

        list.remove(5);

        assertEquals("Wrong tail element", 4, list.peekLast());
        assertEquals("Wrong list size", 4, list.size());
    }

    @Test
    public void removeMiddleElement() {
        LinkedList list = createList();

        list.remove(3);

        assertEquals("Wrong list size", 4, list.size());
        assertEquals("Wrong list content", "1 2 4 5", list.toString());
    }

    @Test
    public void removeLastElement() {
        LinkedList list = createList();

        list.removeLast();

        assertEquals("Wrong tail element", 4, list.peekLast());
        assertEquals("Wrong list size", 4, list.size());
    }

    @Test
    public void getElementIndex() {
        LinkedList list = createList();

        assertEquals("Wrong element index", 0, list.indexOf(1));
        assertEquals("Wrong element index", 2, list.indexOf(3));
        assertEquals("Wrong element index", 4, list.indexOf(5));
    }

    @Test
    public void isEmpty() {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList(Arrays.asList(1));

        assertTrue("List should be empty", list.isEmpty());
        assertFalse("List shouldn't be empty", list2.isEmpty());
    }

    private LinkedList<Integer> createList() {
        return new LinkedList(Arrays.asList(1, 2, 3, 4, 5));
    }
}
