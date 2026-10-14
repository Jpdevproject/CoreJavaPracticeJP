package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrnscationSummrizer {
    record Transaction(String id,String type,Integer amount){};
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("T1", "CREDIT", 100),
                new Transaction("T2", "DEBIT", 50),
                new Transaction("T3", "CREDIT", 200)
        );

        Map<String,Integer> result=transactions.stream()
                .collect(Collectors.groupingBy(Transaction::type,Collectors.summingInt(Transaction::amount)));
        System.out.println(result);
    }
}
