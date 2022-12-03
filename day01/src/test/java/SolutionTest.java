import org.aoc.Solution;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testPart1() throws IOException {
        Solution solution = new Solution();
        var result = solution.part1(Solution.Parser.inputString("testInput.txt"));
        assertEquals(7000, result);
    }

    @Test
    void testPart2() throws IOException {
        System.out.println(new Solution().part2(Collections.unmodifiableList(Solution.Parser.inputString("input.txt"))));

    }

    @Test
    void testParseInputWithString() throws IOException {
        List<String> words = Solution.Parser.inputString("input.txt");

        assertEquals(List.of("hej", "hej"), words);
    }
}