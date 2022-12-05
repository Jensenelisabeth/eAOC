package org.aoc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testPart1() throws IOException {
        Integer result = new Solution().part1(Collections.unmodifiableList(Solution.Parser.inputString("testInput.txt")));
        assertEquals(2, result);
    }

    @Test
    void testPart2() throws IOException {
        Integer result = new Solution().part2(Collections.unmodifiableList(Solution.Parser.inputString("testInput.txt")));
        assertEquals(4, result);
    }
}