package Algorithms.Array.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/
public class EraseOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                res++;
            }
        }

        return intervals.length - res;
    }
}
