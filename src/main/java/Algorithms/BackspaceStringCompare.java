package Algorithms;

// https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare {
    public static boolean compare(String S, String T) {
        int sIdx = S.length() - 1;
        int tIdx = T.length() - 1;


        while (sIdx >= 0 && tIdx >= 0) {
            sIdx = executeBackspace(S, sIdx);
            tIdx = executeBackspace(T, tIdx);
            char s = sIdx >= 0 ? S.charAt(sIdx) : '#';
            char t = tIdx >= 0 ? T.charAt(tIdx) : '#';

            if (s != t) {
                return false;
            }

            sIdx--;
            tIdx--;
        }

        return true;
    }

    private static int executeBackspace(String S, int idx) {
        char backspace = '#';
        int bacspaces = 0;

        while (idx >= 0 && (S.charAt(idx) == backspace || bacspaces > 0)) {
            if (S.charAt(idx) == backspace) {
                bacspaces++;
            } else if (bacspaces > 0) {
                bacspaces--;
            }

            idx--;
        }

        return idx;
    }
}