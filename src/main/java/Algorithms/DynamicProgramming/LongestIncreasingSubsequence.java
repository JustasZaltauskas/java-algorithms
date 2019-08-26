package Algorithms.DynamicProgramming;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static int find(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;

        for (int x : nums) {
            int i = binarySearch(dp, 0, len, x);
            dp[i] = x;

            if (len == i) {
                len++;
            }
        }

        return len;
    }

    private static int binarySearch(int[] arr, int start, int end, int key) {
        while (start < end) {
            int mid = (end + start) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
