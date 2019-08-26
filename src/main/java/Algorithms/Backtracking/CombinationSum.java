package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList(), candidates, target, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            res.add(new ArrayList(temp));
        } else if (remaining < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(res, temp, candidates, remaining - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        backtrackV2(res, new ArrayList(), candidates, target, 0, 0);
        return res;
    }

    private static void backtrackV2(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int pos, int sum) {
        if (!(pos < candidates.length)) {
            return;
        }

        while ((sum + candidates[pos]) <= target) {
            temp.add(candidates[pos]);
            sum += candidates[pos];
        }

        if (sum == target) {
            res.add(new ArrayList(temp));
        }

        while (!temp.isEmpty()) {
            int removed = temp.remove(temp.size() - 1);
            sum -= removed;

            List<List<Integer>> tempRes = new ArrayList();
            List<Integer> temp2;

            backtrackV2(tempRes, new ArrayList(), candidates, target, pos + 1, sum);

            for (List<Integer> r : tempRes) {
                temp2 = new ArrayList(temp);
                temp2.addAll(r);
                res.add(temp2);
            }
        }
    }
}
