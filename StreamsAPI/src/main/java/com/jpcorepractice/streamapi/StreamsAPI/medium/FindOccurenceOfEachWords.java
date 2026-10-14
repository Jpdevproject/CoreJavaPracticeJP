package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOccurenceOfEachWords {
    public static void main(String[] args) {
        String input="I am learning Streams Api in java";
       Map<String,Long> ans= Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println(ans);

    }
}
