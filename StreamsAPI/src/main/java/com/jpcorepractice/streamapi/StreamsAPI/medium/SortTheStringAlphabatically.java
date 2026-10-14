package com.jpcorepractice.streamapi.StreamsAPI.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTheStringAlphabatically {
    public static void main(String[] args) {

        List<String> inputList= Arrays.asList("Zudio","Puma","H&M","Nike","Adidas","Reebok","Sketcher");
         List<String> sortedList = inputList.stream()
                .sorted()
                .collect(Collectors.toList());
         System.out.println(sortedList);
        
    }
}
