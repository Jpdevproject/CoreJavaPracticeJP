package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExtractUniqueWordsFromSentence {
    public static void main(String[] args) {
        List<String> sentences=List.of("java streams","streams are powerful","java is fun");
        Set<String> uniqueWords=sentences.stream()
                .flatMap(s-> Arrays.stream(s.split("\\s+")))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(uniqueWords);
    }
}
