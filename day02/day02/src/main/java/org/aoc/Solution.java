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
       return lines.stream().mapToInt((word) -> getPoint(word)).sum();
    }

    private int getPoint(String word) {
        char elf = word.charAt(0);
        char you = word.charAt(2);
        return getWinnerPoint(elf, you);
    }

    private int getWinnerPoint(char elf, char you) {
        if(elf == 'A'){
            return getElfROCKPoint(you);
        } else if (elf == 'B') {
            return getElfPAPPERPoint(you);
        }else
            return getElfSCISSORPoint(you);
    }

    private int getElfSCISSORPoint(char you) {
        if(you == 'X'){
            return 1 +6;
        } else if (you == 'Y') {
            return 2 ;
        }
        return 3 + 3;
    }

    private int getElfPAPPERPoint(char you) {
        if(you == 'X'){
            return 1 ;
        } else if (you == 'Y') {
            return 2 +3 ;
        }
        return 3 +6;
    }

    private int getElfROCKPoint(char you) {
        if(you == 'X'){
            return 1 + 3;
        } else if (you == 'Y') {
            return 2 + 6;
        }
        return 3;
    }

    private int getPoint(char charAt) {
        if(charAt == 'X'){
            return 1;
        } else if (charAt == 'Y') {
            return 2;
        }
        else
            return 3;
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