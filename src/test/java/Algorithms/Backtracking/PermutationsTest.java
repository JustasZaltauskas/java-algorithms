package Algorithms.Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PermutationsTest {
    @Test
    public void permutations() {
        List<List<Integer>> res = new ArrayList(){
            {
                add(List.of(1, 2, 3));
                add(List.of(1, 3, 2));
                add(List.of(2, 1, 3));
                add(List.of(2, 3, 1));
                add(List.of(3, 1, 2));
                add(List.of(3, 2, 1));
            }
        };

        assertEquals("Wrongs array of permutations", res, Permutations.permute(new int[]{1, 2, 3}));
    }
}
