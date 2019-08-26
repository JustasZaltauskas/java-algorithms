package Algorithms.DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void find() {
        int[] nums = new int[]{2,15,3,7,8,6,18};
        assertEquals("Wrong subsequence length", 5, LongestIncreasingSubsequence.find(nums));
        assertEquals("Wrong subsequence length", 1, LongestIncreasingSubsequence.find(new int[]{1,1}));
        assertEquals("Wrong subsequence length", 0, LongestIncreasingSubsequence.find(new int[]{}));
        assertEquals("Wrong subsequence length", 1, LongestIncreasingSubsequence.find(new int[]{3,2,1}));
    }
}
