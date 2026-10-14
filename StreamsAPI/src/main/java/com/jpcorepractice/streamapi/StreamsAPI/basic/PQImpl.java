package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQImpl {
    public static void main(String[] args) {
        Queue<String> pq=new PriorityQueue<>();
        pq.add("Hello");
        pq.add("HackerRank");
        String s1=pq.poll();
        pq.remove();
        System.out.println(s1);
        String s2=pq.remove();
        System.out.println(s2);
    }
}
