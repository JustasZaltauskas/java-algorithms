package Algorithms.String;

// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstringsV2 {
    public static int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        int count = 1;
        
        for (int i = 0; i < s.length() - 1; i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i + 1);
        }
        
        return count;
    }
    
    public static int countPalindromes(String s, int i, int j) {
        int count = 0;

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    
        return count;
    }
}
