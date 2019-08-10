package Algorithms.Sorting;

interface SortAlgorithm {
    <T extends Comparable<T>> T[] sort(T[] arr);
}