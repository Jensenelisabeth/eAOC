package org.aoc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    void part1() throws IOException {
        List<String> words = Solution.Parser.inputString("testInput.txt");
        Integer result = new Solution().part1(words);
        assertEquals(15, result);

    }
}