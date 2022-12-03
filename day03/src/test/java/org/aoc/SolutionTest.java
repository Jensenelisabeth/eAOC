package org.aoc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void ascciiTranslate() {
        Solution solution = new Solution();
        assertEquals(1, solution.getTranslation('a'));
        assertEquals(27, solution.getTranslation('A'));
    }

    @Test
    void testPart1() throws IOException {
        Integer result = new Solution().part1(Collections.unmodifiableList(Solution.Parser.inputString("testInput.txt")));
        assertEquals(157, result);
    }
}