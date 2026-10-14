package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Top3DistinctNumber {
    public static void main(String[] args) {
        List<Integer> input=List.of(5,1,5,3,9,9,8);
        List<Integer> result = input.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
               // .sorted(Collections.reverseOrder())
                .limit(3)
                .toList();
        System.out.println(result);
    }
}
