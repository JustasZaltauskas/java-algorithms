package Algorithms.Sorting;

import java.util.*;

public class TopKFrequent {
    // Find k most frequent elements using Bucket sort
    public List<Integer> find(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        List<Integer> res = new LinkedList<Integer>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<Integer>();
            }

            buckets[frequency].add(entry.getKey());
        }

        for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] == null) continue;
            for (int j = 0; j < buckets[j].size() && res.size() < k; j++) {
                res.add(buckets[i].get(j));
            }
        }

        return res;
    }
}
