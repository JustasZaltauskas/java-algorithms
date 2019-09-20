package Algorithms.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightsKStops {
    // BFS solution
    // Time, space complexity O(V+E)
    public int find(int n, int[][] flights, int src, int dst, int K) {
        if (flights.length <= 0 || K < 0) return -1;
        Map<Integer, LinkedList<int[]>> g = new HashMap<>();

        for (int[] f : flights) {
            if (!g.containsKey(f[0])) g.put(f[0], new LinkedList());
            g.get(f[0]).add(new int[]{f[1], f[2]});
        }

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{src, 0});
        int res = Integer.MAX_VALUE;
        int steps = 0;

        while (!q.isEmpty() && steps <= K) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] pair = q.remove();
                int s = pair[0];
                if (!g.containsKey(s)) continue;

                for (int[] dest : g.get(s)) {
                    int d = dest[0];
                    int c = pair[1] + dest[1];

                    if (d == dst) {
                        res = Math.min(res, c);
                    } else if (c < res) {
                        q.add(new int[]{d, c});
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
