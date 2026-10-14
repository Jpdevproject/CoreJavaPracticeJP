package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.Comparator;

public class FindWordWithSecondHighestLength {
    public static void main(String[] args) {
        String input="I am learning Streams Api in java";
       String ans= Arrays.stream(input.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst().get();
       System.out.println(ans);
    }
}
