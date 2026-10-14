package com.jpcorepractice.streamapi.StreamsAPI.advanced;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyInLargeText {
    public static void main(String[] args) {
        String input="Java is powerful. Java streams are powerful.";
        Map<String,Long> ans=frequencyOfWord(input);
        System.out.println(ans);
    }

    private static Map<String, Long> frequencyOfWord(String input) {
       return Arrays.stream(input.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}
