package org.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String args[]) throws IOException {
        String part = System.getenv("part") == null ? "part1" : System.getenv("part");
        if (part.equals("part2"))
            System.out.println(new Solution().part2(Collections.unmodifiableList(Parser.inputString("input.txt"))));
        else
            System.out.println(new Solution().part1(Collections.unmodifiableList(Parser.inputString("input.txt"))));

    }

    public Integer part1(List<String> lines) throws IOException {
       return getCalories(lines).get(0);
    }

    public Integer part2(List<String> unmodifiableList) {
    List<Integer> lines = getCalories(unmodifiableList);
    Integer result = lines.get(0) + lines.get(1) + lines.get(2);
    return result;
    }

    private static List<Integer> getCalories(List<String> lines) {
        List<Integer> calories = new ArrayList<>();
        Integer temp = 0;

        for (String calorie: lines) {
            if (!calorie.isEmpty()) {
                temp += Integer.parseInt(calorie);}
            else {
                calories.add(temp);
                temp = 0;
            }
        }
        calories.add(temp);
        Collections.sort(calories);
        Collections.reverse(calories);
        return calories;
    }
    public static class Parser {

        public static List<String> inputString(String fileName) throws IOException {
            return Files.lines(Path.of(fileName)).collect(Collectors.toList());
        }
    }
}
