package Algorithms.Array;

// https://leetcode.com/problems/majority-element/
// Boyer-Moore Voting Algorithm
public class MajorityElement {
    public int find(int[] nums) {
        int freq = 0;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            freq += nums[i] == res ? 1 : -1;

            if (freq <= 0) {
                res = nums[i];
                freq = 1;
            }
        }

        return res;
    }
}
