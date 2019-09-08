package Algorithms.Array;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
public class PartitionLabels {
    public static List<Integer> partition(String S) {
        List<Integer> res = new LinkedList();
        int[] lastIdx = new int[26];
        char[] charArr = S.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            lastIdx[charArr[i] % 26] = i;
        }

        for (int i = 0; i < charArr.length; i++) {
            int start = i;
            int end = lastIdx[charArr[i] % 26];

            while (i < end) {
                int charIdx = charArr[i] % 26;

                if (lastIdx[charIdx] > end) {
                    end = lastIdx[charIdx];
                }

                i++;
            }

            res.add(end - start + 1);
        }

        return res;
    }
}
