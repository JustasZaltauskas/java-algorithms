package Algorithms.DynamicProgramming;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingWater {
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;

        int max = 0;
        for (int i = 0; i < n; i++) {
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }

        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }

        for (int i = 0; i < n; i++) {
            int newWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (newWater > 0) {
                water += newWater;
            }
        }

        return water;
    }
}
