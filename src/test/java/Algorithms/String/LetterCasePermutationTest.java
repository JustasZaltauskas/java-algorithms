package Algorithms.String;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LetterCasePermutationTest {
    @Test
    public void find() {
        assertEquals("Wrong string permutations", List.of("a1b2", "A1b2", "A1B2", "a1B2"), LetterCasePermutation.find("a1b2"));
    }
}
