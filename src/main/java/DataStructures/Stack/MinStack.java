package DataStructures.Stack;

import java.util.LinkedList;

// https://leetcode.com/problems/min-stack/
public class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = getMin();
            minStack.push(x < min ? x : min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
