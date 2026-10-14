package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestWordFinder {
    public static void main(String[] args) {
        List<String> inputList = List.of("Java streams are powerful", "Hackerrank style problems");
        Optional<String> res = inputList.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .max(Comparator.comparingInt(String::length));
        System.out.println(res.get());
    }
}
