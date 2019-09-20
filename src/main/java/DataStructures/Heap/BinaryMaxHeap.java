package DataStructures.Heap;

import DataStructures.Queue.Queue;

import java.util.ArrayList;
import java.util.Collection;

public class BinaryMaxHeap implements Queue<Integer> {
    private ArrayList<Integer> heap;

    public BinaryMaxHeap(int[] arr) {
        heap = new ArrayList<>();
        for (int x : arr) add(x);
    }

    @Override
    public Integer remove() {
        int head = peek();
        heap.set(0, heap.remove(heap.size() - 1));
        siftDown(0);
        return head;
    }

    @Override
    public Integer peek() {
        return heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(Integer x) {
        heap.add(x);
        siftUp(size() - 1);
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void siftUp(int i) {
        int x = heap.get(i);
        while (x > heap.get(getParent(i))) {
            int parentIdx = getParent(i);
            swap(i, parentIdx);
            i = parentIdx;
        }
    }

    private void siftDown(int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int largest = i;

        if (left <= size() && heap.get(i) < left) {
           largest = left;
        }

        if (right <= size() && heap.get(i) < right) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            siftDown(largest);
        }
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private int getParent(int i) {
        return (int) Math.floor((i - 1) / 2);
    }

    @Override
    public void addAll(Collection<Integer> c) {
        for (Integer x : c) add(x);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
}
