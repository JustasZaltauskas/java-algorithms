package Algorithms.Stack;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleArea {
    public static int find(int[] heights) {
        Stack<Integer> prevHeights = new Stack<>();
        Stack<Integer> positions = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
           int h = heights[i];
           int pos = i;

           while (!prevHeights.isEmpty() && prevHeights.peek() > h) {
               pos = positions.pop();
               maxArea = Math.max(maxArea, calculateArea(pos, i, prevHeights.pop()));
           }

           prevHeights.push(h);
           positions.push(pos);
        }

        while (!prevHeights.isEmpty()) {
            maxArea = Math.max(maxArea, calculateArea(positions.pop(), heights.length, prevHeights.pop()));
        }

        return maxArea;
    };

    private static int calculateArea(int prevPos, int pos, int height) {
        return height * ((pos + 1) - (prevPos + 1));
    }
}
