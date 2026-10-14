package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
public class FindWordWithGivenNoOfVowels {
    public static void main(String[] args) {
        String input="I am learning Streams Api in java";
        int vowelNo=2;
        Arrays.stream(input.split(" "))
                .filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==vowelNo)
                .forEach(System.out::println);

    }
}
