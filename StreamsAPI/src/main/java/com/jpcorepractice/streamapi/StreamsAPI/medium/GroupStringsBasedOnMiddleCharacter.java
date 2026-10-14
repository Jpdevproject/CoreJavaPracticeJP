package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsBasedOnMiddleCharacter {
    public static void main(String[] args) {
        String[] s={"xxx","zxc","yzy","pzy"};
         Map<Character,  List<String>> ans = Arrays.stream(s)
                         .collect(Collectors.groupingBy(x->x.charAt(x.length()/2)));

         System.out.println(ans);
    }
}
