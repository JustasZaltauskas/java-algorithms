package Algorithms.DynamicProgramming;

// https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public static int find(int[][] grid) {
        if (grid.length <= 0) return 0;
        int[] dp = grid[0].clone();

        for (int col = 1; col < dp.length; col++) {
            dp[col] += dp[col - 1];
        }

        for (int row = 1; row < grid.length; row++) {
            dp[0] += grid[row][0];

            for (int col = 1; col < grid[row].length; col++) {
                dp[col] = grid[row][col] + Math.min(dp[col - 1], dp[col]);
            }
        }

        return dp[dp.length - 1];
    }
}
