package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateListThatContainNumbers {
    public static void main(String[] args) {
        String[] s={"111","abs","234","feg"};

        List<Integer> ans = Arrays.stream(s)
                .filter(x -> x.matches("[0-9]+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(ans);
    }
}
