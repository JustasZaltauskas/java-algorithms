package Algorithms.Search;

// https://www.geeksforgeeks.org/search-almost-sorted-array/
public class AlmostSortedArray {
    public static <E extends Comparable<E>> int search(E[] arr, E key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> int binarySearch(E[] arr, E key, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            int beforeMid = mid - 1;
            int afterMid = mid + 1;

            if (arr[mid].equals(key)) {
                return mid;
            } else if (mid >= lo && arr[beforeMid].equals(key)) {
                return beforeMid;
            } else if (mid <= hi && arr[afterMid].equals(key)) {
                return afterMid;
            }

            if (arr[mid].compareTo(key) < 0) {
                return binarySearch(arr, key,mid + 2, hi);
            } else if (arr[mid].compareTo(key) > 0) {
                return binarySearch(arr, key, lo, mid - 2);
            }
        }

        return -1;
    }
}
