package Algorithms.Backtracking;

import java.util.*;

// https://leetcode.com/problems/permutations/
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new LinkedHashSet<>(), nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Set<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) {
                    continue;
                }
                temp.add(nums[i]);
                backtrack(res, temp, nums);
                temp.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1,2,3});
        System.out.println(res.toString());
    }
}
