package Algorithms.DynamicProgramming;

// https://leetcode.com/problems/target-sum/
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        return find(nums, S, 0);
    }

    private static int find(int[] nums, int S, int i) {
        if (i == nums.length) return S == 0 ? 1 : 0;
        return find(nums, S + nums[i], i + 1) + 
            find(nums, S - nums[i], i + 1);
    }
}
