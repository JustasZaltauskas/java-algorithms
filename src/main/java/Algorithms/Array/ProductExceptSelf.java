package Algorithms.Array;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {
    public static int[] find(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i - 1];
        }

        int right = 1;

        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] = right * res[i];
        }

        return res;
    }
}
