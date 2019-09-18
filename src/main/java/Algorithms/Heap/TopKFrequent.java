package Algorithms.Heap;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequent {
    // Time complexity O(nlog(k)), n - numbers, k - number of most frequent elements to find
   // Space complexity O(N)
    public List<Integer> find(int[] nums, int k) {
        List<Integer> res = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (Integer number : map.keySet()) {
            pq.add(number);
            if (pq.size() > k) pq.remove();
        }

        while(!pq.isEmpty()) res.add(pq.remove());
        Collections.reverse(res);

        return res;
    }
}
