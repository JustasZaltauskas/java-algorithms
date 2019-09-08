package Algorithms.Array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartitionLabelsTest {
    @Test
    public void partition() {
        assertEquals(
                "Wrong partition of string",
                List.of(4, 1, 1, 3, 1, 1),
                PartitionLabels.partition("ababcefgfij")
        );
    }
}
