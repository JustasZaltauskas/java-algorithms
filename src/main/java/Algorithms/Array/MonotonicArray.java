package Algorithms.Array;

// https://leetcode.com/problems/monotonic-array/
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        int i = 1;

        while (i < A.length && (isIncreasing || isDecreasing)) {
            isIncreasing &= A[i - 1] <= A[i];
            isDecreasing &= A[i - 1] >= A[i];
            i++;
        }

        return isIncreasing || isDecreasing;
    }
}
