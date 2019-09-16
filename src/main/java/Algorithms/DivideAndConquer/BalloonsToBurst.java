package Algorithms.DivideAndConquer;

// https://leetcode.com/problems/burst-balloons/
public class BalloonsToBurst {
    public static int maxCoins(int[] nums) {
        int[] numbers = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) numbers[n++] = x;
        numbers[0] = numbers[n++] = 1;

        return burst(new int[n][n], numbers, 0, n - 1);
    }

    // memo[left][right] - scores of balloons burst between left and right indices
    private static int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];

        int res = 0;
        // k - last balloon to burst
        for (int k = left + 1; k < right; k++) {
            res = Math.max(
                    res,
                    (nums[left] * nums[k] * nums[right]) +
                            burst(memo, nums, left, k) +
                            burst(memo, nums, k, right)
            );
        }

        memo[left][right] = res;
        return res;
    }
}
