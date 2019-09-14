package Algorithms.Array;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public static int find(int[] nums) {
        Set<Integer> set = new HashSet();
        int max = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int longest = 1;

                while (set.contains(currentNum + 1)) {
                    longest++;
                    currentNum++;
                }

                max = Math.max(max, longest);
            }
        }

        return max;
    }
}
