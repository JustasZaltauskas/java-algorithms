package DataStructures.Stack;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-frequency-stack/
public class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> groups;
    int max;

    public FreqStack() {
        freq = new HashMap();
        groups = new HashMap();
        max = 0;
    }

    public void push(int x) {
        Integer curFreq = freq.getOrDefault(x, 0) + 1;
        freq.put(x, curFreq);
        groups.computeIfAbsent(curFreq, z -> new Stack()).push(x);
        max = Math.max(curFreq, max);
    }

    public int pop() {
        int mostFreq = groups.get(max).pop();
        freq.put(mostFreq, freq.get(mostFreq) - 1);

        if (groups.get(max).isEmpty()) {
            max--;
        }

        return mostFreq;
    }
}