package Algorithms.Array;

// https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {
    public void move(int[] nums) {
        int numsLastIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != numsLastIdx) {
                    nums[numsLastIdx] = nums[i];
                    nums[i] = 0;
                }
                numsLastIdx++;
            }
        }
    }
}
