package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckIfTheArrayContainsDistinctValues {
    public static void main(String[] args) {
        int[] a={5,0,1,0,8,0};
         List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
         Map<Integer,  Long> freqMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean ans = freqMap.values().stream().noneMatch(x -> x > 1);
        System.out.println(ans);
    }
}
