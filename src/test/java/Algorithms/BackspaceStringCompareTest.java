package Algorithms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackspaceStringCompareTest {
    @Test
    public void backspaceStringCompareTest() {
        assertTrue("Strings after deletion should be equal", BackspaceStringCompare.compare("ab#c", "ad#c"));
        assertTrue("Strings after deletion should be equal", BackspaceStringCompare.compare("bcde###", "b"));
        assertTrue("Strings after deletion should be equal", BackspaceStringCompare.compare("abc#c##", "a"));
        assertTrue("Strings after deletion should be equal", BackspaceStringCompare.compare("a##c", "#a#c"));
        assertFalse("Strings after deletion should not be equal", BackspaceStringCompare.compare("a#c", "b"));
        assertFalse("Strings after deletion should not be equal", BackspaceStringCompare.compare("bbbextm", "bbb#extm"));
    }
}
