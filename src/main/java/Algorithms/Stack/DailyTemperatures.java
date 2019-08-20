package Algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    public static int[] find(int[] T) {
        Stack<Integer> stack = new Stack();
        int n = T.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);

        for (int i = 0; i < n; i ++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int dayIdx = stack.pop();
                res[dayIdx] = i - dayIdx;
            }

            stack.push(i);
        }

        return res;
    }
}
