package Algorithms.Stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeStringTest {
    @Test
    public void decode() {
        assertEquals("Wrong decoding of string", "abc" , DecodeString.decode("abc"));
        assertEquals("Wrong decoding of string", "aaabcbc" , DecodeString.decode("3[a]2[bc]"));
        assertEquals("Wrong decoding of string", "accaccacc" , DecodeString.decode("3[a2[c]]"));
        assertEquals("Wrong decoding of string", "abcabccdcdcdef" , DecodeString.decode("2[abc]3[cd]ef"));
    }
}
