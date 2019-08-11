package DataStructures;

import DataStructures.Stack.MinStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinStackTest {
    @Test
    public void minStackFindMinElement() {
        MinStack stack = createStack();

        assertEquals("MinStack should find minimum element in stack", -3, stack.getMin());
    }

    @Test
    public void minStackAddElementsInOrder() {
        MinStack stack = createStack();
        stack.pop();

        assertEquals("MinStack should add elements in order", 0, stack.top());
    }

    @Test
    public void minStackShouldFindMinElementAfterPop() {
        MinStack stack = createStack();
        stack.pop();

        assertEquals("MinStack should find minimum element in stack", -2, stack.getMin());
    }

    public MinStack createStack() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        return stack;
    }
}
