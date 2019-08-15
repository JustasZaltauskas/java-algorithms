package Algorithms.Stack;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/
public class DecodeString {
    public static String decode(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack();
        Stack<String> resStack = new Stack();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = 10 * count + c - '0';
            } else if (c == '[') {
                countStack.push(count);
                count = 0;
                resStack.push(res);
                res = "";
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeat = countStack.pop();

                for (int j = 0; j < repeat; j++) {
                    temp.append(res);
                }

                res = temp.toString();
            } else {
                res += c;
            }
        }

        return res;
    }
}
