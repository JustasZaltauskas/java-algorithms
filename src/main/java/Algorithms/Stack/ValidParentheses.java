package Algorithms.Stack;

import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    static Map<Character, Character> parenthesis = Map.of(
            '{', '}',
            '(', ')',
            '[', ']'
    );

    public static boolean isValid(String s) {
        Stack<Character> openedParentheses = new Stack();

        for (char c : s.toCharArray()) {
            if (parenthesis.containsKey(c)) {
                openedParentheses.push(c);
            } else if (openedParentheses.empty() || parenthesis.getOrDefault(openedParentheses.pop(), null) != c) {
                return false;
            }
        }

        return openedParentheses.empty();
    }
}
