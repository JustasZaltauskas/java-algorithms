package Algorithms.Search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlmostSortedArrayTest {
    Integer[] arr = new Integer[]{10, 3, 40, 20, 50, 80, 70};

    @Test
    public void searchSwitchedElementToLeft() {
        assertEquals("Wrong array index", 2, AlmostSortedArray.search(arr, 40));
    }

    @Test
    public void searchSwitchedElementToRightInEnd() {
        assertEquals("Wrong array index", 6, AlmostSortedArray.search(arr, 70));
    }

    @Test
    public void searchSwitchedElementToLeftInBeginning() {
        assertEquals("Wrong array index", 0, AlmostSortedArray.search(arr, 10));
    }

    @Test
    public void searchElementDoesNotExist() {
        assertEquals("Wrong array index", -1, AlmostSortedArray.search(arr, 90));
    }

    @Test
    public void searchEmptyArray() {
        Integer[] arr = new Integer[]{};

        assertEquals("Wrong array index", -1, AlmostSortedArray.search(arr, 10));
    }
}
