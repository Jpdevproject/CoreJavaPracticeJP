package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.stream.Collectors;

public class RemovingDuplicatesAndPreserveOrderOfString {
    public static void main(String[] args) {
        String s="dabcadefg";
        s.chars()
                .mapToObj(c->(char) c)
                .distinct().forEach(System.out::print);
    }
}
