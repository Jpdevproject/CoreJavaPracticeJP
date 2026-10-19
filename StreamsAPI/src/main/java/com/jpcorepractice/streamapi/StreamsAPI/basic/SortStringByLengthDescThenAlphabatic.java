package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.Comparator;
import java.util.List;

public class SortStringByLengthDescThenAlphabatic {
    public static void main(String[] args) {
        List<String> names=List.of("Bob","Alice","Charlie","Ana");
        List<String> sorted=names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
        System.out.println(sorted);

    }
}