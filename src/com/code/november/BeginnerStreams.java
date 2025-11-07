package com.code.november;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BeginnerStreams {

    public static void main(String[] args) {
        System.out.println(List.of(1, 2, 3, 4, 5, 6).stream().filter(n -> n % 2 == 0).collect(Collectors.toList()));
        System.out.println(List.of(10, 20, 30, 40).stream().mapToInt(Integer::intValue).sum());
        System.out.println(List.of("apple", "banana", "cherry").stream().map(String::toUpperCase).collect(Collectors.toList()));
        System.out.println(List.of("Apple", "Avocado", "Banana", "Apricot").stream().filter(str -> str.startsWith("A")).collect(Collectors.toList()));
        System.out.println(List.of(1, 2, 2, 3, 4, 4, 5).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList()));
        Set<Integer> set = new HashSet<>();
        System.out.println(List.of(1, 2, 2, 3, 4, 4, 5).stream().filter(e -> !set.add(e)).collect(Collectors.toList()));
        System.out.println(List.of(5, 2, 9, 1).stream().sorted().collect(Collectors.toList()));
        List.of(5, 2, 9, 1).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(List.of(7, 3, 9, 1, 5).stream().max(Integer::compareTo).get());
        System.out.println(List.of(1, 2, 3, 4).stream().map(v -> v * v).collect(Collectors.toList()));
        System.out.println(List.of(2, 4, 6, 8).stream().allMatch(n -> n % 2 == 0));
    }
}
