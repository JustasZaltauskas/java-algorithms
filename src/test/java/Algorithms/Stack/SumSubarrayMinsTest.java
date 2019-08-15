package Algorithms.Stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumSubarrayMinsTest {
    @Test
    public void calculate() {
        assertEquals("Wrong sum of subarray minimums", 17, SumSubarrayMins.calculate(new int[]{3,1,2,4}));
        assertEquals("Wrong sum of subarray minimums", 18, SumSubarrayMins.calculate(new int[]{8, 5}));
    }
}
