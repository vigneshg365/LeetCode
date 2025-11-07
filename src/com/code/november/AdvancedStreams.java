package com.code.november;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreams {

    public static void main(String[] args) {
//        [
//        new Employee("Alice", "HR", 50000),
//                new Employee("Bob", "IT", 70000),
//                new Employee("Charlie", "HR", 60000)
//]


        List<Employee> employeeList = List.of(
                new Employee(1,"Alice", "HR", 50000, 28, "Female"),
                new Employee(2,"Bob", "IT", 70000, 32, "Male"),
                new Employee(3,"Charlie", "HR", 60000, 30, "Male"),
                new Employee(4,"Diana", "Finance", 80000, 35, "Female"),
                new Employee(5,"Ethan", "IT", 90000, 40, "Male"),
                new Employee(6,"Fiona", "Finance", 75000, 29, "Female"),
                new Employee(7,"George", "IT", 55000, 25, "Male"),
                new Employee(8,"Hannah", "Marketing", 65000, 27, "Female")
        );

        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList()))));

        //2. Find the average salary of each department
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))));


        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.averagingDouble(Employee::getSalary), avg -> Math.round(avg * 100.0) / 100.0))));

        //3. Find the highest-paid employee in each department
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), emp -> emp.map(Employee::getName).get()))));

        //4.Find the names of employees whose salary is greater than their department average
        Map<String, Double> avgSalaryMapByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(employeeList.stream().filter(e -> e.getSalary() > avgSalaryMapByDept.get(e.getDepartment())).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList()))));


        //5. Find the employee with the maximum and minimum salary overall
        Map<Double, List<String>> empSalaryMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));

        double max = empSalaryMap.keySet().stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        double min = empSalaryMap.keySet().stream().mapToDouble(Double::doubleValue).min().getAsDouble();
        System.out.println("max : " + empSalaryMap.get(max) + "\nmin : " + empSalaryMap.get(min));

        //5. Find the employee with the maximum and minimum salary overall (optimized)

        employeeList.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(e -> System.out.println("Max :: " + e.getName() + " :: " + e.getSalary()));
        employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary)).ifPresent(e -> System.out.println("Min :: " + e.getName() + "::" + e.getSalary()));

        // 6. Sort employees by salary in descending order

        System.out.println(employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getName).toList());

        //Find the total salary expense of all employees
        System.out.println(employeeList.stream().mapToDouble(Employee::getSalary).sum());

        //Flatten a list of lists into a single list
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8)
        );
        System.out.println(listOfLists.stream().flatMap(List::stream).collect(Collectors.toList()));

//        9. Find word frequency in a given sentence
//
//                **Input:**
//          `"hello world hello java"`

        Map<String, Long> strOccuranceMap = Arrays.stream("hello world hello java".split(" ")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(strOccuranceMap);
        //10. Find character frequency in a given string

        LinkedHashMap<Character, Long> charOccuranceMap = "banana".chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(charOccuranceMap);

        // 11. Find the longest and shortest string in a list
        //**Input:** `["cat", "elephant", "dog", "tiger"]`

        List.of("cat", "elephant", "dog", "tiger").stream().max(Comparator.comparing(String::length)).ifPresent(e -> System.out.println("Max String :: " + e));
        List.of("cat", "elephant", "dog", "tiger").stream().min(Comparator.comparing(String::length)).ifPresent(e -> System.out.println("Min String :: " + e));

        // 12. Partition a list of numbers into even and odd groups
        //
        //**Input:** `[1, 2, 3, 4, 5, 6]`
        //**Expected Output:**
        //
        //```
        //{
        //  true = [2, 4, 6],   // even
        //  false = [1, 3, 5]   // odd
        //}
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().collect(Collectors.groupingBy(e -> e % 2 == 0, Collectors.mapping(e -> e, Collectors.toList()))));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().collect(Collectors.partitioningBy(e -> e % 2 == 0)));

        //13. Find common elements between two lists
        //
        //**Input:**
        //
        //```
        //List A = [1, 2, 3, 4]
        //List B = [3, 4, 5, 6]
        //```
        //
        //**Expected Output:**
        //
        //```
        //[3, 4]
        List<Integer> listA = List.of(1, 2, 3, 4,0);
        List<Integer> listB = List.of(3, 4, 5, 6);

        System.out.println(Stream.concat(listA.stream(), listB.stream()).filter(el -> listA.contains(el) && listB.contains(el)).collect(Collectors.toSet()));
        System.out.println(listB.stream().filter(listA::contains).toList());

        List<String> fruitList = List.of("apple", "banana");
        System.out.println(fruitList.stream().collect(Collectors.joining()).chars().mapToObj(ch->(char)ch).distinct().collect(Collectors.toList()));

        System.out.println(fruitList.stream().flatMap(str->str.chars().mapToObj(ch->(char)ch)).distinct().toList());


        System.out.println(List.of(5, 2, 9, 1, 7, 3).stream().sorted(Comparator.reverseOrder()).limit(3).toList());

        System.out.println(employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).map(Employee::getName).toList());

        //### 👴 17. Find the oldest and youngest employee

        int maxAge = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).map(Employee::getAge).get();
        int minAge = employeeList.stream().mapToInt(Employee::getAge).min().getAsInt();

        System.out.println(employeeList.stream().filter(e->(e.getAge()==maxAge || e.getAge()==minAge)).collect(Collectors.groupingBy(Employee::getAge,Collectors.mapping(Employee::getName,Collectors.toList()))));

        //### 🚻 18. Group employees by gender and count them

        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName,Collectors.toList()))));
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));

        int minNum = Integer.MAX_VALUE;
        for(Integer num : listA){
            if(num<minNum)
                minNum = num;
        }
        System.out.println("min Number : "+minNum);
        //19. Convert list of objects into a map (id → name)
        System.out.println(employeeList.stream().collect(Collectors.toMap(Employee::getId,Employee::getName)));

        //Calculate total and average marks of students by subject
        Map<String, Double> averageMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.averagingDouble(Employee::getSalary),e->Math.round(e/100.0)*100.0)));
        Map<String,Double> totalMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)));
        System.out.println(averageMap+"\n"+totalMap);

        Map<String, Map<String, Double>> summarizedSumAverageMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                Collectors.summarizingDouble(Employee::getSalary), stat -> Map.of("total", stat.getSum(), "average", Math.round(stat.getAverage()*100.0)/100.0))));

        System.out.println(summarizedSumAverageMap);

        //list min and max of every dept
        Map<String, Map<String, Integer>> deptWiseAgeGroupMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.summarizingInt(Employee::getAge), stat -> Map.of("Min", stat.getMin(), "Max", stat.getMax()))));
        System.out.println(deptWiseAgeGroupMap);
    }
}
