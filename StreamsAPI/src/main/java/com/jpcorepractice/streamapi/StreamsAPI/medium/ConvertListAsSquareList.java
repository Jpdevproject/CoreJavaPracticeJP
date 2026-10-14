package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConvertListAsSquareList {
    public static void main(String[] args) {
        int[] input={1,2,3,4,5};
        var list = Arrays.stream(input)
                .map(x -> x * x)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
