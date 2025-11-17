package com.aasov.dailyJava.allStream; /**
 * Java Stream API Practice Questions (40 Exercises)
 * Difficulty: Medium → Advanced
 *
 * Each question is presented as a static method with an example solution.
 * You can run this class and call the methods individually for practice.
 */
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamAPIPractice {

    public static void main(String[] args) {
        // Run any method to test it out
        q13();
        // Example: q15(); or q30();
    }

    // ---------- LEVEL 1: Medium (Basics + Intermediate) ----------

    // 1. Convert list of strings to uppercase
    static void q1() {
        List<String> names = List.of("alice", "bob", "charlie");
        List<String> result = names.stream().map(String::toUpperCase).toList();
        System.out.println(result);
    }

    // 2. Filter even numbers
    static void q2() {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        List<Integer> even = nums.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(even);
    }

    // 3. Sum of numbers
    static void q3() {
        List<Integer> nums = List.of(1,2,3,4);
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    // 4. Find first name starting with "A"
    static void q4() {
        List<String> names = List.of("Bob", "Alice", "Andy");
        names.stream().filter(n -> n.startsWith("A")).findFirst().ifPresent(System.out::println);
    }

    // 5. Count how many start with "A"
    static void q5() {
        List<String> names = List.of("Amy", "Bob", "Alex", "Brian");
        long count = names.stream().filter(n -> n.startsWith("A")).count();
        System.out.println(count);
    }

    // 6. Sort by string length
    static void q6() {
        List<String> names = List.of("Java", "Stream", "API");
        List<String> sorted = names.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(sorted);
    }

    // 7. Remove duplicates
    static void q7() {
        List<Integer> nums = List.of(1,2,2,3,3,4);
        List<Integer> distinct = nums.stream().distinct().toList();
        System.out.println(distinct);
    }

    // 8. Join strings
    static void q8() {
        List<String> names = List.of("Java", "Stream", "API");
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined);
    }

    // 9. Map list to string lengths
    static void q9() {
        List<String> names = List.of("apple", "banana", "kiwi");
        List<Integer> lengths = names.stream().map(String::length).toList();
        System.out.println(lengths);
    }

    // 10. Find max number
    static void q10() {
        List<Integer> nums = List.of(3,5,7,2);
        nums.stream().max(Integer::compareTo).ifPresent(System.out::println);
    }

    // ---------- LEVEL 2: Intermediate (Collectors + Grouping) ----------

    // 11. Group employees by department
    static void q11() {
        record Emp(String name, String dept) {}
        List<Emp> list = List.of(new Emp("A","IT"), new Emp("B","HR"), new Emp("C","IT"));
        Map<String, List<Emp>> result = list.stream().collect(Collectors.groupingBy(Emp::dept));
        System.out.println(result);
    }

    // 12. Count employees per department
    static void q12() {
        record Emp(String name, String dept) {}
        List<Emp> list = List.of(new Emp("A","IT"), new Emp("B","HR"), new Emp("C","IT"));
        Map<String, Long> count = list.stream().collect(Collectors.groupingBy(Emp::dept, Collectors.counting()));
        System.out.println(count);
    }

    // 13. Average salary by department
    static void q13() {
        record Emp(String name, String dept, double salary) {}
        List<Emp> list = List.of(new Emp("A","HR",3000), new Emp("B","IT",4000), new Emp("C","IT",5000));
        Map<String, Double> avg = list.stream().collect(Collectors.groupingBy(Emp::dept, Collectors.averagingDouble(Emp::salary)));
        System.out.println(avg);
    }

    // 14. Flatten list of lists
    static void q14() {
        List<List<Integer>> lists = List.of(List.of(1,2), List.of(3,4));
        List<Integer> flat = lists.stream().flatMap(Collection::stream).toList();
        System.out.println(flat);
    }

    // 15. Second highest number
    static void q15() {
        List<Integer> nums = List.of(1, 4, 2, 9, 5);
        int second = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println(second);
    }

    // 16. Partition numbers into even/odd
    static void q16() {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        Map<Boolean, List<Integer>> parts = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(parts);
    }

    // 17. Top 3 largest
    static void q17() {
        List<Integer> nums = List.of(10,20,30,40,50);
        List<Integer> top3 = nums.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(top3);
    }

    // 18. All names start with uppercase?
    static void q18() {
        List<String> names = List.of("John", "Doe", "Jane");
        boolean result = names.stream().allMatch(n -> Character.isUpperCase(n.charAt(0)));
        System.out.println(result);
    }

    // 19. Parallel stream example
    static void q19() {
        List<Integer> nums = IntStream.rangeClosed(1, 100).boxed().toList();
        long count = nums.parallelStream().filter(n -> n % 2 == 0).count();
        System.out.println("Even count: " + count);
    }

    // 20. Custom reduce operation
    static void q20() {
        List<Integer> nums = List.of(1,2,3,4);
        int product = nums.stream().reduce(1, (a,b) -> a*b);
        System.out.println("Product: " + product);
    }

    // ---------- LEVEL 3: Advanced (Complex Transformations) ----------

    // 21. Find frequency of each character in a string
    static void q21() {
        String str = "banana";
        Map<Character, Long> freq = str.chars().mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);
    }

    // 22. Find the longest string
    static void q22() {
        List<String> list = List.of("cat", "elephant", "dog");
        list.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
    }

    // 23. Concatenate list of integers into a single string
    static void q23() {
        List<Integer> nums = List.of(1,2,3,4);
        String s = nums.stream().map(String::valueOf).collect(Collectors.joining("-"));
        System.out.println(s);
    }

    // 24. Sort map by value (descending)
    static void q24() {
        Map<String, Integer> map = Map.of("A",3,"B",1,"C",2);
        map.entrySet().stream()
            .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));
    }

    // 25. Find duplicate elements in a list
    static void q25() {
        List<Integer> nums = List.of(1,2,2,3,4,4,5);
        Set<Integer> duplicates = nums.stream()
            .filter(n -> Collections.frequency(nums, n) > 1)
            .collect(Collectors.toSet());
        System.out.println(duplicates);
    }

    // 26. Remove null and empty strings
    static void q26() {
        List<String> list = Arrays.asList("A", "", null, "B", " ");
        List<String> cleaned = list.stream()
            .filter(Objects::nonNull)
            .filter(s -> !s.isBlank())
            .toList();
        System.out.println(cleaned);
    }

    // 27. Find common elements between two lists
    static void q27() {
        List<Integer> a = List.of(1,2,3,4);
        List<Integer> b = List.of(3,4,5,6);
        List<Integer> common = a.stream().filter(b::contains).toList();
        System.out.println(common);
    }

    // 28. Sum of squares of numbers
    static void q28() {
        List<Integer> nums = List.of(1,2,3,4);
        int result = nums.stream().map(n -> n*n).reduce(0, Integer::sum);
        System.out.println(result);
    }

    // 29. Convert list of objects to map (name->salary)
    static void q29() {
        record Emp(String name, int salary) {}
        List<Emp> emps = List.of(new Emp("A",1000), new Emp("B",2000));
        Map<String,Integer> map = emps.stream().collect(Collectors.toMap(Emp::name, Emp::salary));
        System.out.println(map);
    }

    // 30. Find the most frequent element
    static void q30() {
        List<Integer> nums = List.of(1,1,2,2,2,3);
        int mode = nums.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Most frequent: " + mode);
    }

    // 31. Find intersection using retainAll alternative
    static void q31() {
        List<Integer> a = List.of(1,2,3,4);
        List<Integer> b = List.of(3,4,5,6);
        List<Integer> result = a.stream().filter(new HashSet<>(b)::contains).toList();
        System.out.println(result);
    }

    // 32. Custom comparator: sort by last character
    static void q32() {
        List<String> list = List.of("apple", "banana", "kiwi");
        List<String> sorted = list.stream().sorted(Comparator.comparing(s -> s.charAt(s.length()-1))).toList();
        System.out.println(sorted);
    }

    // 33. Convert array to stream and compute average
    static void q33() {
        int[] arr = {10, 20, 30, 40};
        double avg = Arrays.stream(arr).average().orElse(0);
        System.out.println(avg);
    }

    // 34. Get distinct sorted characters from string
    static void q34() {
        String s = "streamapi";
        List<Character> chars = s.chars().mapToObj(c -> (char)c).distinct().sorted().toList();
        System.out.println(chars);
    }

    // 35. Find all palindromes in list
    static void q35() {
        List<String> words = List.of("madam", "hello", "racecar");
        List<String> palin = words.stream()
            .filter(w -> new StringBuilder(w).reverse().toString().equals(w))
            .toList();
        System.out.println(palin);
    }

    // 36. Convert list to comma-separated string with prefix/suffix
    static void q36() {
        List<String> list = List.of("one","two","three");
        String result = list.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    // 37. Find top N frequent elements
    static void q37() {
        List<String> words = List.of("a","b","a","c","a","b");
        Map<String, Long> freq = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> top2 = freq.entrySet().stream()
            .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
            .limit(2)
            .map(Map.Entry::getKey)
            .toList();
        System.out.println(top2);
    }

    // 38. Group words by first letter
    static void q38() {
        List<String> words = List.of("apple", "banana", "apricot", "cherry");
        Map<Character, List<String>> grouped = words.stream()
            .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(grouped);
    }

    // 39. Calculate factorial using streams
    static void q39() {
        int n = 5;
        long fact = LongStream.rangeClosed(1, n).reduce(1, (a,b) -> a*b);
        System.out.println(fact);
    }

    // 40. Find longest word starting with given letter
    static void q40() {
        List<String> words = List.of("apple", "apricot", "banana", "avocado");
        char letter = 'a';
        words.stream()
            .filter(w -> w.startsWith(String.valueOf(letter)))
            .max(Comparator.comparingInt(String::length))
            .ifPresent(System.out::println);
    }
}
