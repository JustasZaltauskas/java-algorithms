package Algorithms.DynamicProgramming;

// https://leetcode.com/problems/target-sum/
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        Integer[][] memo = new Integer[nums.length][2001];
        return find(nums, S, 0, 0, memo);
    }
    
    public static int find(int[] nums, int S, int i, int sum, Integer[][] memo) {
        if (i >= nums.length) return sum == S ? 1 : 0;
        if (memo[i][sum + 1000] != null) return memo[i][sum + 1000];
        
        memo[i][sum + 1000] = find(nums, S, i + 1, sum + nums[i], memo) +
            find(nums, S, i + 1, sum - nums[i], memo);
        
        return memo[i][sum + 1000];
    }
}
