package Algorithms.DivideAndConquer;

// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
// Quick select algorithm. Choose last element as a pivot.
public class kLargestElement {
    public int find(int[] nums, int k) {
        sort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    private void sort(int[] nums, int lo, int hi, int k) {
        if (lo < hi) {
            int pivot = partition(nums, lo, hi);

            if (pivot < k) {
                sort(nums, pivot + 1, hi, k);
            } else if (pivot > k) {
                sort(nums, lo, pivot - 1, k);
            }
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int leftIdx = lo;
        int pivotIdx = hi;

        for (int i = leftIdx; i < hi; i++) {
            if (nums[i] < nums[pivotIdx]) {
                swap(nums, leftIdx, i);
                leftIdx++;
            }
        }

        swap(nums, leftIdx, pivotIdx);
        return leftIdx;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
