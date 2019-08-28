package Algorithms.Array;

// https://leetcode.com/problems/relative-sort-array/
public class RelativeSortArray {
    public int[] sort(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        int k = 0;

        for (int x : arr1) {
            cnt[x]++;
        }

        for (int x : arr2) {
            while (cnt[x]-- > 0) {
                arr1[k++] = x;
            }
        }

        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]-- > 0) {
                arr1[k++] = i;
            }
        }

        return arr1;
    }
}
