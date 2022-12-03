package org.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {


    public static void main(String args[]) throws IOException {
        String part = System.getenv("part") == null ? "part1" : System.getenv("part");
        if (part.equals("part2"))
            System.out.println(new Solution().part2(Collections.unmodifiableList(Parser.inputString("input.txt"))));
        else
            System.out.println(new Solution().part1(Collections.unmodifiableList(Parser.inputString("input.txt"))));

    }

    public int part2(List<String> unmodifiableList) {
        return partition(unmodifiableList).stream().mapToInt(this::getBadge).map(this::getTranslation).sum();
    }

    private int getBadge(List<String> strings) {
       return strings.get(0).chars()
              .filter((a)-> strings.get(1).contains(Character.toString(a)) && strings.get(2).contains(Character.toString(a))).findFirst().orElse(0);
    }


    private static Collection<List<String>> partition(List<String> collection) {
        AtomicInteger counter = new AtomicInteger();
        return collection.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 3))
                .values();
    }


    public Integer part1(List<String> lines) {
      return lines.stream().mapToInt(this::findLetter).sum();
    }

    private int findLetter(String line) {
        int half = line.length()/2;
           String first = line.substring(0, half);
           CharSequence second = line.subSequence(half, line.length());
          return second.chars()
                  .map(i -> (char) i )
                  .filter(a -> first.contains(Character.toString(a)))
                  .map(this::getTranslation)
                  .findFirst().orElseThrow();
    }


    public int getTranslation(int letter) {
       return letter > 96 ? letter -96 : letter - 38;
    }

    public static class Parser {

        public static List<String> inputString(String fileName) throws IOException {
            return Files.lines(Path.of(fileName)).collect(Collectors.toList());
        }
    }
}