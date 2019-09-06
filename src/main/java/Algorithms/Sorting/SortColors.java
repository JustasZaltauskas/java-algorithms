package Algorithms.Sorting;

// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public void sort(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        for (int i = 0; i <= hi; i++) {
            while (nums[i] == 2 && i < hi) {
                int temp = nums[i];
                nums[i] = nums[hi];
                nums[hi--] = temp;
            }
            while (nums[i] == 0 && i > lo) {
                int temp = nums[i];
                nums[i] = nums[lo];
                nums[lo++] = temp;
            }
        }
    }

    // Two-pass algorithm
    public void sortV2(int[] nums) {
        int[] frequencies = new int[3];

        for (int num : nums) {
            frequencies[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            while (frequencies[j] <= 0) j++;
            frequencies[j]--;
            nums[i] = j;
        }
    }
}
