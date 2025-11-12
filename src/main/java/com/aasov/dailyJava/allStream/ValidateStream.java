package com.aasov.dailyJava.allStream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ValidateStream {



    public static void main(String[] args) {

        // Q1. Convert a List of Strings to Uppercase
        List<String> names = List.of("alice", "bob", "charlie");
        List<String> result = names.stream().map(String::toUpperCase).toList();
        System.out.println("Result ::>" + result);

        //Q2. Filter Even Numbers from a List
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<Integer> intResult= numbers.stream().filter(x -> x%2==0).collect(Collectors.toList());
        System.out.println(intResult);

        // SUM OF A LIST
        int sum = numbers.stream().mapToInt(x-> x.intValue()).sum();
        System.out.println(sum);

        // Q4. Find the First Element Starting with “A”
        List<String> namesList = List.of("Bob", "Alice", "Andy", "Brian");
        Optional<String> aResult = namesList.stream()
                        .filter(n -> n.startsWith("A"))
                        .findFirst();
        System.out.println(aResult.get());

        //Q5. Count How Many Names Start with a Given Letter
        Long count = namesList.stream().count();
        Long startWithAcount = namesList.stream().filter(x -> x.startsWith("A")).count();

        System.out.println("Count::"+count);
        System.out.println("startWithAcount::"+startWithAcount);



    }
}
