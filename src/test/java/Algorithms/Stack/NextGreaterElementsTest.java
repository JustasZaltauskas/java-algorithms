package Algorithms.Stack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextGreaterElementsTest {
    @Test
    public void find2() {
        int [] result = NextGreaterElements.find2(new int[]{1, 2, 1});
        int [] expected = new int[]{2, -1, 2};
        assertArrayEquals("Wrong array of next greater elements", expected, result);
    }
}
