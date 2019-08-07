package Algorithms.Sorting;

import java.util.Arrays;

class QuickSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        sortRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    private <T extends Comparable<T>> void sortRecursive(T[] arr, int start, int end) {
        if (start < end) {
            int pivotIdx = partition(arr, start, end);
            sortRecursive(arr, start, pivotIdx - 1);
            sortRecursive(arr, pivotIdx + 1, end);
        }
    }

    private <T extends Comparable<T>> int partition(T[] arr, int start, int end) {
        int leftArrIdx = start;
        T pivot = arr[end];

        for (int i = start; i < end; i++) {
            T el = arr[i];

            if (el.compareTo(pivot) < 0) {
                T temp = arr[leftArrIdx];
                arr[leftArrIdx] = el;
                arr[i] = temp;
                leftArrIdx++;
            }
        }

        T temp = arr[leftArrIdx];
        arr[leftArrIdx] = pivot;
        arr[end] = temp;

        return leftArrIdx;
    }

    public static void main (String[] args) {
        Integer[] array = {3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));

        String[] stringArray = {"c", "a", "e", "b", "d"};
        quickSort.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));
    }
}