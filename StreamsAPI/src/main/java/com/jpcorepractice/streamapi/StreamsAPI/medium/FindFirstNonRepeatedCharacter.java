package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;

public class FindFirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String s="Hello World";
         String ans = Arrays.stream(s.split(""))
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst()
                .get();
         System.out.println(ans);
    }
}
