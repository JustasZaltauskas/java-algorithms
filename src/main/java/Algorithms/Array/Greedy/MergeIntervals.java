package Algorithms.Array.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/discuss/21242/C%2B%2B-10-line-solution.-easing-understanding
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>(intervals.length);
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.get(res.size() - 1)[1]) {
                int[] prev = res.remove(res.size() - 1);
                res.add(new int[]{prev[0], Math.max(prev[1], intervals[i][1])});
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][res.get(0).length]);
    }
}
