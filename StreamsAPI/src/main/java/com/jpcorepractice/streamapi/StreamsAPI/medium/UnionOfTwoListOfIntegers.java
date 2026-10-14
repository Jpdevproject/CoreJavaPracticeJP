package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnionOfTwoListOfIntegers {
    public static void main(String[] args) {
        List<Integer> input1= Arrays.asList(1,2,2,3,5,9,8,6,15,7,7,9);
        List<Integer> input2= Arrays.asList(1,24,22,23,50,19,8,6,15,78,7,9);

        List<Integer> unionResult = Stream.concat(input1.stream(), input2.stream())
              //  .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(unionResult);
    }
}
