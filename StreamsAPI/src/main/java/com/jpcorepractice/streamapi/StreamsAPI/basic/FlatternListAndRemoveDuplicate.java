package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.List;

public class FlatternListAndRemoveDuplicate {
    public static void main(String[] args) {
        List<List<Integer>> data=List.of(List.of(1,2),List.of(3,4,5,5),List.of(5,6));
        List<Integer> flatternData=data.stream()
                .flatMap(List::stream)
                .distinct()
                .toList();
        System.out.println(flatternData);
    }
}
