package Algorithms.DivideAndConquer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/different-ways-to-add-parentheses/
public class DiffWaysToCompute {
    static Map<String, List<Integer>> cache = new HashMap<>();

    public static List<Integer> compute(String input) {
        if (cache.containsKey(input)) return cache.get(input);
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                List<Integer> part1 = compute(input.substring(0, i));
                List<Integer> part2 = compute(input.substring(i + 1));

                for (int p1 : part1) {
                    for (int p2 : part2) {
                        if(input.charAt(i) == '+') res.add(p1 + p2);
                        else if(input.charAt(i) == '-') res.add(p1 - p2);
                        else if(input.charAt(i) == '*') res.add(p1 * p2);
                    }
                }
            }
        }

        if (res.isEmpty()) res.add(Integer.valueOf(input));

        return res;
    }

    public static void main(String[] args) {
        System.out.println(compute("2-1-1"));
    }
}
