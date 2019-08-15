package Algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    // https://leetcode.com/problems/next-greater-element-ii/
    public static int[] find2(int[] nums) {
        int n = nums.length;
        // Indices of numbers we search greater number for
        Stack<Integer> numsIdxToFind = new Stack();
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n * 2; i++) {
            int idx = i % n;

            while (!numsIdxToFind.isEmpty() && nums[numsIdxToFind.peek()] < nums[idx]) {
                res[numsIdxToFind.pop()] = nums[idx];
            }

            if (idx < nums.length) {
                numsIdxToFind.push(idx);
            }
        }

        return res;
    }
}
