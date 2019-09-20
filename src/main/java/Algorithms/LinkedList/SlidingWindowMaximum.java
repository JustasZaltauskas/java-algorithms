package Algorithms.LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/sliding-window-maximum
public class SlidingWindowMaximum {
    // Solved using a monotonic queue
    public int[] find(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        // Store indices
        Deque<Integer> q = new ArrayDeque<>();
        // Start writing to res array;
        int startPos = k - 1;

        for (int i = 0; i < nums.length; i++) {
            // Maintain decreasing queue
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            // Remove elements out of the window
            while (!q.isEmpty() && (i - q.peekFirst()) >= k) {
                q.removeFirst();
            }
            q.addLast(i);

            if (i >= startPos)  res[i - startPos] = nums[q.peekFirst()];
        }

        return res;
    }
}
