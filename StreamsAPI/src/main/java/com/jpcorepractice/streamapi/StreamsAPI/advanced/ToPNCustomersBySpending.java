package com.jpcorepractice.streamapi.StreamsAPI.advanced;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToPNCustomersBySpending {
    record Transaction(String tId,String cId,Integer amount){};
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("T1", "C1", 200),
                new Transaction("T2", "C2", 300),
                new Transaction("T3", "C1", 400),
                new Transaction("T4", "C3", 500)
        );
        int N=2;
        Map<String,Integer>  result= ToPNCustomersBySpending.findTopNSpending(transactions,N);
         System.out.println(result);

    }

    private static Map<String, Integer> findTopNSpending(List<Transaction> transactions, int n) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::cId,Collectors.summingInt(Transaction::amount)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(a,b)->a,LinkedHashMap::new));

    }


}
