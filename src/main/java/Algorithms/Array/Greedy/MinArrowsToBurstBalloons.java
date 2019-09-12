package Algorithms.Array.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class MinArrowsToBurstBalloons {
    public static int find(int[][] points) {
        if (points.length <= 0) return 0;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int[] prev = points[0];
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= prev[1]) {
                prev = new int[]{points[i][0], Math.min(points[i][1], prev[1])};
            } else {
                prev = points[i];
                count++;
            }
        }

        return count;
    }
}
