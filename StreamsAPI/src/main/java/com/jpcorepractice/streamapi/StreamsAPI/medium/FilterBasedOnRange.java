package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterBasedOnRange {
    public static void main(String[] args) {
        int[] input={1,2,55,45,32,39,98,92,72,79};
        Map<Integer, List<Integer>>  ans=solve(input);
        System.out.println(ans);
    }

    private static Map<Integer, List<Integer>> solve(int[] input) {
        List<Integer> list = Arrays.stream(input).boxed().toList();
        return list.stream().collect(Collectors.groupingBy(x->x/10*10,Collectors.toList()));
    }
}
