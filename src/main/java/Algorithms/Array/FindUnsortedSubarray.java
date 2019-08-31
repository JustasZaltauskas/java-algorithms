package Algorithms.Array;

import java.util.Arrays;

public class FindUnsortedSubarray {
    // Time - O(nlogn), Space - O(n)
    public static int find(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int lo = 0;
        int hi = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                if (lo == 0) lo = i + 1;
                if (lo != 0) hi = i + 1;
            }
        }

        return hi == 0 ? 0 : hi - lo + 1;
    }

    // Time - O(n), Space - O(1)
    public static int findV2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int lo = 0;
        int hi = 0;
        boolean flag = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }

        flag = false;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }

        for (lo = 0; lo < nums.length; lo++) {
            if (nums[lo] > min) {
                break;
            }
        }

        for (hi = nums.length - 1; hi >= 0; hi--) {
            if (nums[hi] < max) {
                break;
            }
        }

        return hi <= 0 ? 0 : hi - lo + 1;
    }
}
