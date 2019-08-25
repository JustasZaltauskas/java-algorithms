package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        backtrack(res, new ArrayList(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int pos) {
        if (temp.size() == k) {
            res.add(new ArrayList(temp));
        } else {
            for (int i = pos; i <= n; i++) {
                temp.add(i);
                backtrack(res, temp, n, k, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
