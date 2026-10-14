package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromeFilter {
    public static void main(String[] args) {
        List<String> inputList = List.of("madam", "racecar", "hello", "nursesrun");
         List<String> result = inputList.stream()
                .filter(s -> {
                    String cleaned = s.replaceAll("\\s+", "");
                    IntStream.range(0, cleaned.length() / 2)
                            .allMatch(i -> cleaned.charAt(i) == cleaned.charAt(cleaned.length() - 1 - i));

                    return true;
                })
                .collect(Collectors.toList());
         System.out.println(result);

    }
}
