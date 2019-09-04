package Algorithms.Array;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SortedSquares {
    public int[] find(int[] A) {
        int[] res = new int[A.length];
        int p1 = 0;
        int p2 = A.length - 1;

        while (p1 <= p2) {
            int i = p2 - p1;

            if (Math.abs(A[p1]) < Math.abs(A[p2])) {
                res[i] = A[p2] * A[p2];
                p2--;
            } else {
                res[i] = A[p1] * A[p1];
                p1++;
            }
        }

        return res;
    }
}
