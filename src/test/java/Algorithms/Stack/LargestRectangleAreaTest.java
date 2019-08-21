package Algorithms.Stack;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleAreaTest {
    @Test
    public void find() {
        Assert.assertEquals("Wrong rectangle area in histogram", 10, LargestRectangleArea.find(new int[]{0, 3, 2, 3, 4, 3, 1, 1, 1, 1, 1}));
        Assert.assertEquals("Wrong rectangle area in histogram", 3, LargestRectangleArea.find(new int[]{2, 1, 2}));
        Assert.assertEquals("Wrong rectangle area in histogram", 10, LargestRectangleArea.find(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals("Wrong rectangle area in histogram", 9, LargestRectangleArea.find(new int[]{1, 2, 3, 4, 5}));
    }
}
