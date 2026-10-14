package com.jpcorepractice.streamapi.StreamsAPI.advanced;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        List<Integer> inputList = List.of(100, 4, 200, 1, 3, 2);
        List ans=longestConsecutive(inputList);
        System.out.println(ans);
    }

    private static List longestConsecutive(List<Integer> inputList) {
       Set<Integer> set = inputList.stream().collect(Collectors.toSet());
      return  set.stream()
               .filter(n->!set.contains(n-1))
               .map(n->{
                   List<Integer> seq=new ArrayList<>();
                   Integer current=n;
                   while (set.contains(current)){
                       seq.add(current);
                       current++;
                   }
                   return  seq;
               })
               .max(Comparator.comparing(List::size))
              .orElse(Collections.EMPTY_LIST);
    }
}
