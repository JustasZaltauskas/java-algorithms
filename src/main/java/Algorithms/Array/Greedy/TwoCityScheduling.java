package Algorithms.Array.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/two-city-scheduling/
public class TwoCityScheduling {
    /*
        [Cost A, Cost B]
        Input: [[10,20],[30,200],[400,50],[30,20]]
        Output: 110

        If we send lowest As then we have to send remaining Bs no matter
        their cost. Therefore we have to selects As by their cost relative
        to cost of B. So we choose lowest As with highest cost of Bs.
    */
    public static int schedule(int[][] costs) {
        int n = costs.length / 2;
        int totalCost = 0;

        Arrays.sort(costs, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0] + costs[costs.length - 1 - i][1];
        }

        return totalCost;
    }
}
