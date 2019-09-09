package Algorithms.Array.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
C
// https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {
    public static int find(int[] stones) {
        List<Integer> l = Arrays.stream(stones).boxed().collect(Collectors.toList());
        Collections.sort(l, Collections.reverseOrder());

        while (l.size() > 1) {
            int i = 1;

            if (l.get(i) == l.get(i - 1)) {
                l.remove(i);
                l.remove(i - 1);
                i--;
            } else {
                int weight = l.get(i - 1) - l.get(i);
                l.remove(i);
                l.remove(i - 1);

                int lo = 0;
                int hi = l.size() - 1;
                int insertIdx = -1;

                while (lo <= hi) {
                    int mid = (hi + lo) / 2;

                    if (l.get(mid) == weight) {
                        insertIdx = mid;
                        break;
                    } else if (l.get(mid) < weight) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }

                insertIdx = insertIdx >= 0 ? insertIdx : lo;
                l.add(insertIdx, weight);
            }
        }

        return l.size() > 0 ? l.get(0) : 0;
    }
}
