package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] s={"pat","tap","pan","tree","meat","nap"};

         Map<Object,  List<String>> ans = Arrays.asList(s)
                .stream()
                .collect(Collectors.groupingBy(x -> Arrays.stream(x.split("")).sorted().collect(Collectors.toList()) ));
         System.out.println(ans);

    }
}
