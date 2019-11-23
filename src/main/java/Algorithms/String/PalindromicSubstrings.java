package Algorithms.String;

// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
     public static int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j)) res++;
            }
        }

        return res;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if (i > j) return false;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
