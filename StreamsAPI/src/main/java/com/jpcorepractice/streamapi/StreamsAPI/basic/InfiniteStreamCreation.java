package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.List;
import java.util.stream.Stream;

public class InfiniteStreamCreation {
    public static void main(String[] args) {
        List<Integer> result = Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .limit(10)
                .map(a -> a[0])
                .toList();
        System.out.println(result);
    }
}
