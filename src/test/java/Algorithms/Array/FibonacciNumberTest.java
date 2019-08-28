package Algorithms.Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciNumberTest {
    // {input, output}
    int[][] testCases = new int[][]{
            new int[]{0, 0},
            new int[]{1, 1},
            new int[]{2, 1},
            new int[]{3, 2},
            new int[]{4, 3}
    };

    @Test
    public void fib() {
        for (int[] test : testCases) {
            assertEquals("Wrong fibonacci sequence", test[1], FibonacciNumber.fib(test[0]));
        }
    }

    @Test
    public void fibRecursive() {
        for (int[] test : testCases) {
            assertEquals("Wrong fibonacci sequence", test[1], FibonacciNumber.fibRecursive(test[0]));
        }
    }
}
