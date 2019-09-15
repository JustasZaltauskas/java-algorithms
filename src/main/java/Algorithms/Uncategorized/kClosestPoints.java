package Algorithms.Uncategorized;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class kClosestPoints {
    public int[][] find(int[][] points, int K) {
        if (points.length <= K) return points;

        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> getDistance(a) - getDistance(b));

        for (int[] point : points) q.add(point);
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++) res[i] = q.remove();

        return res;
    }

    public int[][] findV2(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> getDistance(a) - getDistance(b));
        return Arrays.copyOfRange(points, 0, K);
    }

    private int getDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}
