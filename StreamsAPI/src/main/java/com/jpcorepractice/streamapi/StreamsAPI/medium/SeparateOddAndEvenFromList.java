package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeparateOddAndEvenFromList {
    public static void main(String[] args) {
        int[] input={1,2,3,4,5,6,7,8,9};
         Map< Boolean,  List<Integer>> filtered = Arrays.stream(input)
                .boxed()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));

         System.out.println(filtered.get(true));
         System.out.println(filtered.get(false));
    }
}
