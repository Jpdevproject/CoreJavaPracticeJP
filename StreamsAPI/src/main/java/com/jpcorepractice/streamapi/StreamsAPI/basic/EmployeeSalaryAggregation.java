package com.jpcorepractice.streamapi.StreamsAPI.basic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EmployeeSalaryAggregation {
    record Employee(String name,String dept,Integer salary){};
    public static void main(String[] args) {
        List<Employee> inputList = List.of(
                new Employee("Alice", "HR", 5000),
                new Employee("Bob", "IT", 7000),
                new Employee("Charlie", "IT", 6000),
                new Employee("David", "HR", 5500));
         Map<String, Double> res = inputList.stream()
                .collect(Collectors.groupingBy(Employee::dept, Collectors.averagingInt(Employee::salary)));
         res.entrySet().forEach(e ->System.out.println(e.getKey()+"->"+e.getValue()) );





    }
}
