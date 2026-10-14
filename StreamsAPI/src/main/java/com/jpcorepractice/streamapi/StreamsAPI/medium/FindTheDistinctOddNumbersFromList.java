package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;

public class FindTheDistinctOddNumbersFromList {
    public static void main(String[] args) {
        List<Integer> input= Arrays.asList(1,2,2,3,5,9,8,6,15,7,7,9);
        List<Integer> output = input.stream()
                .distinct()
                .filter(x -> x % 2 != 0)
                .toList();
        System.out.println(output);
    }
}
