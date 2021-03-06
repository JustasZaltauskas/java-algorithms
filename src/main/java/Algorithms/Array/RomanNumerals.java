package Algorithms.Array;

// https://leetcode.com/problems/roman-to-integer
public class RomanNumerals {
    public static int romanToInt(String s) {
        int res = 0;

        if (s.indexOf("IV") != -1 || s.indexOf("IX") != -1) res-= 2;
        if (s.indexOf("XL") != -1 || s.indexOf("XC") != -1) res-= 20;
        if (s.indexOf("CD") != -1 || s.indexOf("CM") != -1) res-= 200;

        for (char c : s.toCharArray()) {
            if (c == 'I') res += 1;
            if (c == 'V') res += 5;
            if (c == 'X') res += 10;
            if (c == 'L') res += 50;
            if (c == 'C') res += 100;
            if (c == 'D') res += 500;
            if (c == 'M') res += 1000;
        }

        return res;
    }
}
