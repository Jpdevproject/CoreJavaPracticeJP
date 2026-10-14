package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoveAllZeroToBeginningOfArray {
    public static void main(String[] args) {
        int[] a={5,0,1,0,8,0};
        List<Integer> list= Arrays.stream(a).boxed().toList();
         Map< Boolean,  List<Integer>> partitionedMap = list.stream()
                .collect(Collectors.partitioningBy(x -> x != 0));
        // System.out.println(partitionedMap);
//         String ans = partitionedMap.entrySet()
//                .stream()
//                .flatMap(entry -> entry.getValue().stream())
//                .map(String::valueOf)
//                .collect(Collectors.joining(","));
      //  System.out.println("{"+ans+"}");
         List<Integer> finalList = partitionedMap.values().stream()
                .flatMap(x -> x.stream()).collect(Collectors.toList());
         System.out.println(finalList);

    }
}
