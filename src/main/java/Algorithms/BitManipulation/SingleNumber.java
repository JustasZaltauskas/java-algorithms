package Algorithms.BitManipulation;

// https://leetcode.com/problems/single-number/
public class SingleNumber {
    public static int find (int[] nums) {
        int res = 0;

        for (int x : nums)
            res ^= x;

        return res;
    }
}
