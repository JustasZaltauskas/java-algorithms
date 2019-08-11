package Algorithms.Stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {
    @Test
    public void isValid() {
        assertTrue("Parentheses should be valid", ValidParentheses.isValid("()"));
        assertTrue("Parentheses should be valid", ValidParentheses.isValid("()[]{}"));
        assertTrue("Parentheses should be valid", ValidParentheses.isValid("([])"));
        assertFalse("Parentheses should be invalid", ValidParentheses.isValid("(}"));
        assertFalse("Parentheses should be invalid", ValidParentheses.isValid("(("));
        assertFalse("Parentheses should be invalid", ValidParentheses.isValid("1"));
    }
}
