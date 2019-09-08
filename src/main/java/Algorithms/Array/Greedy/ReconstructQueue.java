package Algorithms.Array.Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/queue-reconstruction-by-height/
public class ReconstructQueue {
    public static int[][] reconstruct(int[][] people) {
        List<int[]> res = new LinkedList();
        int j = 0;

        Arrays.sort(people, (a, b) -> {
            return b[0] == a[0] ? a[1] - b[1] : b[0] - a[0];
        });

        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[people.length][]);
    }
}
