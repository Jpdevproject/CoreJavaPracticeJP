package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindProductOfFirstTwoElement {
    public static void main(String[] args) {
        int[] a={12,5,6,7,8,9};
        Integer product = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .limit(2)
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);
    }
}
