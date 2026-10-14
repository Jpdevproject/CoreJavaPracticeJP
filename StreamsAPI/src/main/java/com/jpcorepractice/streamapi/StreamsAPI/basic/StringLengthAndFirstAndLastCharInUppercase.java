package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringLengthAndFirstAndLastCharInUppercase {
    public static void main(String[] args) {
        String s="all the best";
        String result=Arrays.stream(s.split(" "))
                .map(word->{
                    int len=word.length();
                    char first=Character.toUpperCase(word.charAt(0));
                    char last=Character.toUpperCase(word.charAt(len-1));
                    String middle=word.substring(1,len-1);
                    return first+middle+last+len;
                })
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
