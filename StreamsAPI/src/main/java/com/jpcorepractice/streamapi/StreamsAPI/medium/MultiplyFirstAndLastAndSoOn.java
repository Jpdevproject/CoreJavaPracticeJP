package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.stream.IntStream;

public class MultiplyFirstAndLastAndSoOn {
    public static void main(String[] args) {
        int[] a={4,5,1,7,2,9,2,3};
        int n=a.length;
        IntStream.range(0,a.length/2)
                .map(x->a[x]*a[n-x-1])
                .forEach(System.out::println);

    }
}
