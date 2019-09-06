package Algorithms.Array.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    /*
    [A,A,A,B,B,C], n = 2 (how much to wait to be able to  execute same task)
    A x x A xx A
    A B C A B X A - idle = 1
    mostFrequent = 3 (A)
    frequentCount = 1 (A is the only most frequent element)
    emptySpaces = count(A) - 1 = 2 (2 empty spaces between A's)
    emptySlots = emptySpaces * n = 4 (4 empty slots between A's)
    availableTasks =  = tasks.length - frequentCount * mostFrequent = 6 - 3 = 3
    idle = emptySlots - availableTasks = 1;
    result = idle + tasks.length = 1 + 6 = 7
    */
    public static int leastInterval(char[] tasks, int n) {
        int mostFrequent = 0;
        int frequentCount = 0;
        int[] todo = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            int idx = tasks[i] % 26;

            if (++todo[idx] > mostFrequent) {
                mostFrequent = todo[idx];
                frequentCount = 1;
            } else if (todo[idx] == mostFrequent) {
                frequentCount++;
            }
        }

        int emptySpaces = mostFrequent - 1;
        int slotLength = n - (frequentCount - 1);
        int emptySlots = emptySpaces * slotLength;
        int availableTasks = tasks.length - mostFrequent * frequentCount;
        int idle = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idle;
    }

    // Implementation using PriorityQueue to prioritise tasks with highest frequency
    public int leastIntervalV2(char[] tasks, int n) {
        int intervals = 0;
        Map<Character, Integer> todo = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> q  = new PriorityQueue<>(
                (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey()
        );

        for (char task : tasks) {
            todo.put(task, todo.getOrDefault(task, 0) + 1);
        }

        q.addAll(todo.entrySet());

        while (!q.isEmpty()) {
            int waitTime = n + 1;
            ArrayList<Map.Entry<Character, Integer>> tempList = new ArrayList();

            while (waitTime > 0 && !q.isEmpty()) {
                Map.Entry<Character, Integer> top = q.poll();
                top.setValue(top.getValue() - 1);
                if (top.getValue() > 0) tempList.add(top);
                waitTime--;
                intervals++;
            }

            q.addAll(tempList);
            if (!q.isEmpty()) intervals += waitTime;
        }

        return intervals;
    }
}
