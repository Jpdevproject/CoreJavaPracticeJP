package com.jpcorepractice.streamapi.StreamsAPI.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnargamGrouping {
    public static void main(String[] args) {

        List<String> list = List.of("eat", "tea", "tan", "ate", "nat", "bat");
         Map<String, List<String>> result = list.stream()
                .collect(Collectors.groupingBy(s -> {
                    char[] arr = s.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                }));
         System.out.println(result.values());



    }
}
