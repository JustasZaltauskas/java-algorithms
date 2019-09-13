package Algorithms.Array.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class MinArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 0) return 0;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int prevEnd = points[0][1];
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= prevEnd) {
                prevEnd = Math.min(points[i][1], prevEnd);
            } else {
                prevEnd = points[i][1];
                count++;
            }
        }

        return count;
    }

}
