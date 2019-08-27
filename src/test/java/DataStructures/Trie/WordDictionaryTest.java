package DataStructures.Trie;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordDictionaryTest {
    @Test
    public void wordSearch() {
        WordDictionary dict = new WordDictionary();
        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");

        assertFalse("Word should not be found in Word dictionary", dict.search("a"));
        assertFalse("Word should not be found in Word dictionary", dict.search(".at"));
        dict.addWord("bat");
        assertTrue("Word should be found in Word dictionary", dict.search(".at"));
        assertTrue("Word should be found in Word dictionary", dict.search("an."));
        assertFalse("Word should not be found in Word dictionary", dict.search("a.d."));
        assertFalse("Word should be not found in Word dictionary", dict.search("b."));
        assertTrue("Word should be found in Word dictionary", dict.search("a.d"));
        assertFalse("Word should bot be found in Word dictionary", dict.search("."));
    }
}
