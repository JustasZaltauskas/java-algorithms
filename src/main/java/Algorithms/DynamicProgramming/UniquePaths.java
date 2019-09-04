package Algorithms.DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] += dp[col - 1];
            }
        }

        return dp[n - 1];
    }
}
