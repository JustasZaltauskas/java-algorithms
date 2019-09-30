package Algorithms.DynamicProgramming;

// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
// Time: O(n^3), Space: O(n^2)
public class MinCostFromLeafNodes {
    public static int find(int[] arr) {
        int len = arr.length;
        int[][] memo = new int[len][len];
        int[][] max = new int[len][len];

        for (int i = 0; i < len; i++) {
            int localMax = 0;

            for (int j = i; j < len; j++) {
                if (arr[j] > localMax) localMax = arr[j];
                max[i][j] = localMax;
            }
        }

        return dp(0, arr.length - 1, max, memo);
    }

    private static int dp(int left, int right, int[][] max, int[][] memo) {
        // leaf node
        if (left >= right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int res = Integer.MAX_VALUE;

        for (int k = left; k < right; k++) {
            int leftSubtree = dp(left, k, max, memo);
            int rightSubtree = dp(k + 1, right, max, memo);
            res = Math.min(res, leftSubtree + rightSubtree + (max[left][k] * max[k + 1][right]));
        }

        memo[left][right] = res;
        return res;
    }

    public static int findIterative(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        int[][] max = new int[len][len];

        for (int i = 0; i < len; i++) {
            int localMax = 0;

            for (int j = i; j < len; j++) {
                if (arr[j] > localMax) localMax = arr[j];
                max[i][j] = localMax;
            }
        }

        for (int length = 1; length < len; length++) {
            for (int left = 0; (left + length) < len; left++) {
                int right = left + length;
                dp[left][right] = Integer.MAX_VALUE;

                for (int k = left; k < right; k++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k + 1][right] + (max[left][k] * max[k + 1][right]));
                }
            }
        }

        return dp[0][arr.length - 1];
    }
}
