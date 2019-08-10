package Algorithms.Sorting;

import java.util.Arrays;

class MergeSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        sortRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    private <T extends Comparable<T>> void sortRecursive(T[] arr, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            sortRecursive(arr, start, mid);
            sortRecursive(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public <T extends Comparable<T>> void merge(T[] arr, int start, int mid, int end) {
        int newLen = end - start + 1;
        T[] temp = (T[]) new Comparable[newLen];
        int i = start;
        int j = mid + 1;
        int tempIdx = 0;

        while (i <= mid || j <= end) {
            T a = i <= mid ? arr[i] : null;
            T b = j <= end ? arr[j] : null;

            if (a == null || b != null && a.compareTo(b) >= 0) {
                temp[tempIdx] = b;
                j++;
                tempIdx++;
            }

            if (b == null || a != null && a.compareTo(b) <= 0) {
                temp[tempIdx] = a;
                i++;
                tempIdx++;
            }
        }

        for (i = 0; i < newLen; i++) {
            arr[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Integer[] numbers = new Integer[]{5, 4, 6, 3, 10, 9, 8, 55, 55, 55, 0};
        mergeSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] chars = new String[]{"B", "A", "D", "C"};
        mergeSort.sort(chars);
        System.out.println(Arrays.toString(chars));
    }
}
