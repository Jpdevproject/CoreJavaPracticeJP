package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.Comparator;

public class FindWordWithMaxLength {
    public static void main(String[] args) {
        String input="I am learning Streams Api in java";
       String ans = Arrays.stream(input.split(" ")).max(Comparator.comparing(String::length)).get();
       System.out.println(ans);
    }
}
