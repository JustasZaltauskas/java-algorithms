package Algorithms.DynamicProgramming;

// https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromeSubseq {
    public static int find(String s) {
        return helper(s, 0, s.length() - 1, new int[s.length()][s.length()]);
    }

    private static int helper(String s, int i, int j, int[][]dp) {
        if (dp[i][j] > 0) return dp[i][j];
        if (i > j) return 0;
        if (i == j) return 1;

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = helper(s, i + 1, j - 1, dp) + 2;
        } else {
            dp[i][j] = Math.max(
                    helper(s, i + 1, j, dp),
                    helper(s, i , j - 1, dp)
            );
        }

        return dp[i][j];
    }
}
