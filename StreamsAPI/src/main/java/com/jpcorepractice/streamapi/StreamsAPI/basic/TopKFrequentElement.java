package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TopKFrequentElement {
    public static void main(String[] args) {
        List<Integer> inputList = List.of(1, 1, 2, 2, 2, 3, 3, 4);
        int k=2;
        List<Integer> res1=solveAscendingIfFrequencyIsTie(inputList,k);
        System.out.println(res1);
        List<Integer> res2=solveDescendingIfFrequencyIsTie(inputList,k);
        System.out.println(res2);

    }

   /* private static List<Integer> solveDescendingIfFrequencyIsTie(List<Integer> inputList, int k) {
         Map<Integer,Long> freqMap = inputList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return freqMap.entrySet().stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<Integer,Long>comparingByKey().reversed()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());


    }*/

    private static List<Integer> solveAscendingIfFrequencyIsTie(List<Integer> inputList, int k) {
         Map<Integer, Long> freqMap = inputList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return  freqMap.entrySet().stream()
                 .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()
                 .thenComparing(Map.Entry.comparingByKey()))
                  .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


    }

    private static List<Integer> solveDescendingIfFrequencyIsTie(List<Integer> inputList, int k) {
        Map<Integer,Long> freqMap=inputList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return freqMap.entrySet().stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()
                       // .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                       .thenComparing(Map.Entry.comparingByKey(Collections.reverseOrder())))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
