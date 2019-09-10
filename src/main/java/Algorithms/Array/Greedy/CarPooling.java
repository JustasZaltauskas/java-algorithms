package Algorithms.Array.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public static boolean run(int[][] trips, int capacity) {
        if (trips.length == 0) return false;
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>(trips.length, (a, b) -> a[2] - b[2]);

        for (int[] trip : trips) {
            while (!q.isEmpty() && q.peek()[2] <= trip[1]) {
                int[] lastTrip = q.poll();
                capacity += lastTrip[0];
            }

            q.add(trip);
            capacity -= trip[0];

            if (capacity < 0) return false;
        }

        return true;
    }
}
