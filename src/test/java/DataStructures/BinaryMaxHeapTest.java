package DataStructures;

import DataStructures.Heap.BinaryMaxHeap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryMaxHeapTest {
    @Test
    public void heapSize() {
        BinaryMaxHeap heap = new BinaryMaxHeap(new int[]{7, 8, 6, 5, 4, 3});
        assertEquals("Wrong binary heap size", 6, heap.size());
    }

    @Test
    public void heapAdd() {
        BinaryMaxHeap heap = new BinaryMaxHeap(new int[]{7, 8, 6, 5, 4, 3});
        assertEquals("Wrong binary heap head node", Integer.valueOf(8), heap.peek());
        heap.add(10);
        assertEquals("Wrong binary heap head node after add operation", Integer.valueOf(10), heap.peek());
    }

    public void heapRemove() {
        BinaryMaxHeap heap = new BinaryMaxHeap(new int[]{7, 3, 5, 6, 4, 8});
        assertEquals("Wrong binary heap head node after remove operation", Integer.valueOf(8), heap.remove());
        assertEquals("Wrong binary heap head node after remove operation", Integer.valueOf(7), heap.remove());
        assertEquals("Wrong binary heap head node after remove operation", Integer.valueOf(6), heap.remove());
    }
}
