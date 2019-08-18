package Algorithms.Stack;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/
public class Find132pattern {
    public static boolean find132pattern(int[] nums) {
        int s1Candidate = Integer.MIN_VALUE;
        int s3Candidate = Integer.MIN_VALUE;
        Stack<Integer> s2 = new Stack();
        int i = nums.length - 1;

        while (i >= 0) {
            s1Candidate = nums[i];

            if (s1Candidate < s3Candidate) {
                return true;
            } else while (!s2.isEmpty() && s1Candidate > s2.peek()) {
                s3Candidate = s2.pop();
            }

            s2.push(s1Candidate);
            i--;
        }


        return false;
    }
}
