package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FindLengthOfSecondHighestWord {
    public static void main(String[] args) {
        String input="I am learning Streams Api in java";
       int ans= Arrays.stream(input.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .map(String::length)
                .get();
       System.out.println(ans);

    }
}
