package Algorithms.Stack;

import DataStructures.LinkedList.Node;

import java.util.ArrayList;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextLargerNodes {
    public static int[] find(Node head) {
        ArrayList<Integer> arr = new ArrayList();
        Stack<Integer> prevElementsIndices = new Stack();

        for (Node node = head; node != null; node = node.next) {
            arr.add((int)node.val);
        }

        int[] res = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            int el = arr.get(i);

            while (!prevElementsIndices.isEmpty() && arr.get(prevElementsIndices.peek()) <  el) {
                res[prevElementsIndices.pop()] = el;
            }

            prevElementsIndices.push(i);
        }

        return res;
    }
}
