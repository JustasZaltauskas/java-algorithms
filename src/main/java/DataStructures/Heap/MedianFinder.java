package DataStructures.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> small;
    Queue<Integer> large;

    public MedianFinder() {
        // Store larger size of array
        small = new PriorityQueue<>();
        // Store smaller size of array
        large = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        small.add(num);
        large.add(small.remove());

        if (large.size() > small.size()) {
            small.add(large.remove());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return (double) small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
