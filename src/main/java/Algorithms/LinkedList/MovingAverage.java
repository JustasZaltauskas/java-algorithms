package Algorithms.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

// https://www.lintcode.com/problem/moving-average-from-data-stream
public class MovingAverage {
    Queue<Integer> q;
    int size;
    double sum;

    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (q.size() == size) {
            sum -= q.remove();
        }

        q.add(val);
        sum += val;

        return sum / q.size();
    }
}