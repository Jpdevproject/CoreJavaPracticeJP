package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;

public class SumOfAllElemtsInList {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int sum = Arrays.stream(arr)
                        .reduce(0,(a,b)->a+b);

        System.out.println(sum);
    }

}
