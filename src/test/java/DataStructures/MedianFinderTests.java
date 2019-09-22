package DataStructures;

import DataStructures.Heap.MedianFinder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianFinderTests {
    @Test
    public void twoHeapsTest() {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);

        assertEquals("Wrong median when even number of elements", 1.5, finder.findMedian(), 0);
        finder.addNum(3);
        assertEquals("Wrong median when odd number of elements", 2, finder.findMedian(), 0);
        finder.addNum(0);
        assertEquals("Wrong median when odd number of elements", 1.5, finder.findMedian(), 0);
    }
}
