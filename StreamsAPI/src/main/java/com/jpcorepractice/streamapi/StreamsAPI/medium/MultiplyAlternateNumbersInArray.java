package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.stream.IntStream;

public class MultiplyAlternateNumbersInArray {
    public static void main(String[] args) {
        int[] a={4,5,1,7,2,9,2};
      int ans = IntStream.range(0,a.length)
              .filter(x->x%2==0)
              .map(x->a[x])
              .reduce(1,(m,n)->m*n);
      System.out.println(ans);
    }
}
