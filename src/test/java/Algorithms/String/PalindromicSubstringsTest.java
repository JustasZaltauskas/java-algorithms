package Algorithms.String;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PalindromicSubstringsTest {
    String[] input = {"aaa", "aba", "abba"};
    int[] expected = {6, 4, 6};
    String errorMessage = "Wrong palindromic substrings count";

    @Test
    public void countSubstrings() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(errorMessage, expected[i], PalindromicSubstrings.countSubstrings(input[i]));
        }
    }

    @Test
    public void countSubstringsV2() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(errorMessage, expected[i], PalindromicSubstringsV2.countSubstrings(input[i]));
        }
    }
}
