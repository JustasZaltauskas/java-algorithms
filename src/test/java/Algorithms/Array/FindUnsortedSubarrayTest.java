package Algorithms.Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindUnsortedSubarrayTest {
    int[][] input = new int[][]{
//            {1, 3, 2, 4, 5},
            {1, 2, 3},
//            {3, 2, 1},
//            {2, 6, 4, 8, 10, 9, 15},
//            {1, 3, 5, 4, 2},
//            {1, 2, 3, 3, 3}
    };

    int[] expected = new int[]{0};
//    int[] expected = new int[]{2, 0, 3, 5, 4, 0};

    @Test
    public void find() {
        for (int i = 0; i < input.length; i++) {
            assertEquals("Wrong unsorted continuous array length", expected[i], FindUnsortedSubarray.find(input[i]));
        }
    }

    @Test
    public void findV2() {
        for (int i = 0; i < input.length; i++) {
            assertEquals("Wrong unsorted continuous array length", expected[i], FindUnsortedSubarray.findV2(input[i]));
        }
    }
}
