package Algorithms.Stack;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-minimums/
class SumSubarrayMins {
    public static int calculate(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Stack<Integer> leftNumbers = new Stack();
        Stack<Integer> rightNumbers = new Stack();

        for (int i = 0; i < left.length; i++) left[i] = 1;
        for (int i = 0; i < right.length; i++) right[i] = 1;
        
        for (int i = 0; i < A.length; i++) {
            while (!leftNumbers.isEmpty() && A[leftNumbers.peek()] > A[i]) {
                int index = leftNumbers.pop();
                left[i] += left[index];
            }
            
            leftNumbers.push(i);
        }
        
        for (int i = A.length - 1; i >= 0; i--) {
            while (!rightNumbers.isEmpty() && A[rightNumbers.peek()] >= A[i]) {
                int index = rightNumbers.pop();
                right[i] += right[index];
            }

            rightNumbers.push(i);
        }
        
        int res = 0;
        int mod = (int)1e9 + 7;
        
        for (int i = 0; i < A.length; i++) {
            res = (res + A[i] * left[i] * right[i]) % mod;
        }
        
        return  res;
    }
}