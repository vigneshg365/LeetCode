package com.code.november;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateStreams {

    public static void main(String[] args) {

//        🟡 1. Find the first non-repeated character in a string
//
//        Input: "swiss"
//        Expected Output: 'w'
//        Explanation:
//        s repeats, w appears once first.

        System.out.println("swiss".chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get());


//        Input: "programming"
//        Expected Output: 'r'
//        Explanation:
//        r is the first character that repeats.
                Set<Character> set = new HashSet();
        System.out.println("programming".chars().mapToObj(ch->(char)ch).filter(val->!set.add(val)).findFirst().get());

//        Input: List.of(10, 20, 10, 30, 20, 40)
//        Expected Output: [10, 20, 30, 40]
//        Explanation: Keeps only unique elements.

        System.out.println(List.of(10, 20, 10, 30, 20, 40).stream().distinct().toList());

//        5. Find the second highest number in a list
//
//        Input: List.of(10, 50, 30, 70, 40)
//        Expected Output: 50
//        Explanation: Sorted descending → [70, 50, 40, 30, 10].

        System.out.println( List.of(10, 50, 30, 70, 40).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        System.out.println(List.of(10, 50, 30, 70, 40).stream().sorted().skip(1).findFirst().get());

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (Integer num : List.of(10, 50, 30, 70, 40)){

            if(num>firstMax){
                secondMax = firstMax;
                firstMax = num;
            }else if(num>secondMax && num<firstMax)
                secondMax = num;


            if(num<firstMin){
                secondMin =firstMin;
                firstMin = num;
            }else if(num<secondMin && num>firstMin)
                secondMin = num;

        }

        System.out.println("FirstMin ::"+firstMin+"\t2ndMin :: "+secondMin+"\nFirstMax :: "+firstMax+" \t2ndMax :: "+secondMax);

//        Input:
//        List A → [1, 2, 3]
//        List B → [3, 4, 5]
//        Expected Output: [1, 2, 3, 4, 5]

       // List.of(1,2,3).stream().flatMap(List.of(3, 4, 5).stream()).distinct().collect(Collectors.toList());
        System.out.println(Stream.of(List.of(1,2,3),List.of(3, 4, 5)).flatMap(List::stream).distinct().toList());

//        8. Find elements present in one list but not in another
//
//        Input:
//        List A → [1, 2, 3, 4]
//        List B → [3, 4, 5, 6]
//        Expected Output: [1, 2]

        List<Integer> listA = Arrays.asList(1, 2, 3, 4);
        List<Integer> listB = Arrays.asList(3, 4, 5, 6);

        System.out.println(Stream.concat(listA.stream().filter(v->!listB.contains(v)),listB.stream().filter(v->!listA.contains(v))).toList());

//        9. Count number of strings with length greater than 5
//
//        Input: List.of("apple", "banana", "cherry", "fig", "mango")
//        Expected Output: 2
//        Explanation: “banana” and “cherry” have length > 5.

        System.out.println(List.of("apple", "banana", "cherry", "fig", "mango").stream().filter(v->v.length()>5).count());

//        🟡 10. Convert list of strings to a single comma-separated string
//
//        Input: List.of("Java", "Spring", "Docker")
//        Expected Output: "Java,Spring,Docker"

        System.out.println(String.join(",", List.of("Java", "Spring", "Docker")));



    }
}
