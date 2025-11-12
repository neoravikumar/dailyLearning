package com.aasov.dailyJava.allStream;

import java.util.*;

public class StreamAPIPractive2 {

    public static void main(String[] args) {
        //question1();
        //question4();
        //question6();
        //question8();
        //question9();
        //question10();
        //question11();
        question12();
    }
    //1.  Find all even numbers from a list using streams.
    static void question1(){
        List<Integer> allInteger  = Arrays.asList(8,2,70,96,85,63,66,5);
        List<Integer> result = allInteger.stream().filter(a -> a%2==0).toList();
        System.out.println(result);

    }
    //2.  Convert a list of strings to uppercase using stream operations.
    static void question2(){
        List<String> listOfString = Arrays.asList("ravi", "sumit","amit","govind");
        List<String> result = listOfString.stream().map(a->a.toUpperCase()).toList();
        System.out.println(result);
    }

    //3.  Find the sum of all numbers in a list using streams.
    static void question3(){
        List<Integer> allInteger  = Arrays.asList(8,2,7,3,80,4);
        int result = allInteger.stream().mapToInt(a->a).sum();
        System.out.println(result);
    }

    //4.  Find the maximum number in a list using streams.
    static void question4(){
        List<Integer> allInteger  = Arrays.asList(8,2,7,3,80,4);
        Optional<Integer> result = allInteger.stream().max(Integer::compareTo);
        System.out.println(result.get());
    }

    //5.  Find the minimum number in a list using streams.
    static void question5(){
        List<Integer> allInteger  = Arrays.asList(8,2,7,3,80,4);
        Optional<Integer> result = allInteger.stream().min((x,y) -> Integer.compare(x,y));
        System.out.println(result.get());
    }

    // 6. Count how many strings in a list start with a specific letter.
    static void question6(){
        List<String> listOfString = Arrays.asList("ravi", "sumit","parmit","govind","arun");
        Long result = listOfString.stream().filter(a->a.startsWith("a")).count();
        System.out.println(result);
    }

    // 7. Remove duplicates from a list using streams.
    static void question7(){
        List<Integer> allInteger  = Arrays.asList(8,2,7,3,80,4, 8);
        List<Integer> result = allInteger.stream().distinct().toList();
        System.out.println(result);
    }

    //8.  Sort a list in ascending order using streams.
    static void question8(){
        List<Integer> allInteger  = Arrays.asList(8,2,7,3,80,4, 8);
        List<Integer> result = allInteger.stream().sorted().toList();
        System.out.println(result);
    }

    //9.  Sort a list in desc order using streams.
    static void question9(){
        List<Integer> allInteger  = Arrays.asList(8,2,7,3,80,4, 8);
        List<Integer> result = allInteger.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(result);
    }

    //10. Find the first element of a stream.
    static void question10(){
        List<Integer> allInteger  = Arrays.asList(98,2,7,3,80,4, 8);
        Optional<Integer> result = allInteger.stream().findFirst();
        System.out.println(result.get());
    }

    //11. Find the second-largest number in a list using streams.
    static void question11(){
        List<Integer> allInteger  = Arrays.asList(98,2,7,3,80,4, 8);
        List<Integer> result = allInteger.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println(result.get(1));
    }

    //12. Remove empty or blank strings from a list using streams.
    static void question12(){
        List<String> listOfString = Arrays.asList("ravi", "sumit","parmit","govind","arun", "", "prashant",null);
        List<String> result = listOfString.stream()
                .filter(Objects::nonNull)
                        .filter(a -> !a.isEmpty())
                                .toList();

        System.out.println(result);
    }


/*Basic Level:
1.  Find all even numbers from a list using streams.
2.  Convert a list of strings to uppercase using stream operations.
3.  Find the sum of all numbers in a list using streams.
4.  Find the maximum number in a list using streams.
5.  Find the minimum number in a list using streams.
6.  Count how many strings in a list start with a specific letter.
7.  Remove duplicates from a list using streams.
8.  Sort a list in ascending order using streams.
9.  Sort a list in descending order using streams.
10. Find the first element of a stream.

Intermediate Level:
11. Find the second-largest number in a list using streams.
12. Remove empty or blank strings from a list using streams.
13. Group a list of objects by a specific property using streams.
14. Use a stream to filter objects based on multiple conditions.
15. Flatten a list of lists into a single list using flatMap.
16. Use reduce to concatenate a list of strings into a single string.
17. Find the average of a list of integers using streams.
18. Partition a list of integers into even and odd numbers using streams.
19. Count the frequency of characters in a string using streams.
20. Use streams to collect elements into a Map with custom keys and values.

Advanced Level:
21. Use primitive streams (IntStream, LongStream, DoubleStream) to perform calculations.
22. Use a custom collector to collect stream elements into a specific collection type.
23. Use parallel streams to perform a computationally intensive operation.
24. Use streams to perform a groupBy and then sum operation on grouped elements.
25. Implement a stream pipeline that handles optional values with map and flatMap.
26. Use streams to find the top N elements from a list based on a comparator.
27. Use streams with CompletableFuture for asynchronous computations.
28. Stream a large file line-by-line and process the lines using filter and map.
29. Use streams to calculate the longest increasing subsequence from a list of integers.
30. Create a custom stream operation using the StreamSupport class*/
}
