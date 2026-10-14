package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceOfCharacterInAWord {
    public static void main(String[] args) {
        String s="streams";
         Map<Character,  Long> ans = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         System.out.println(ans);
    }
}
