package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrangeNumberInArrayToFormHighestAndLowestNumber {
    public static void main(String[] args) {
        int[] A={1,2,36,4,5};
         List<Integer> max = Arrays.stream(A)
               .boxed()
                // .mapToObj(x->x)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
         System.out.println(max);
    }
}
