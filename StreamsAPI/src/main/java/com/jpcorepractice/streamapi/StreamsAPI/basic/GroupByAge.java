package com.jpcorepractice.streamapi.StreamsAPI.basic;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByAge {
    record Person(String name,int age){};
    public static void main(String[] args) {
        List<Person> peopleList=List.of(new Person("A",20),new Person("B",30),new Person("C",20));
        Map<Integer,  List<Person>> groupByAge = peopleList.stream()
                .collect(Collectors.groupingBy(Person::age));
        System.out.println("groupByAge:"+groupByAge);
         Map<Integer,  Long> countByAge = peopleList.stream()
                .collect(Collectors.groupingBy(Person::age, Collectors.counting()));
         System.out.println("countByAge:"+countByAge);

        
    }
}
