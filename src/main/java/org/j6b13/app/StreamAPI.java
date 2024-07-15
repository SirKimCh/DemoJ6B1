package org.j6b13.app;

import org.j6b13.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    static List<Student> listStudent = Arrays.asList(
            new Student("Alice", true, 90.0),
            new Student("Bob", true, 100.0),
            new Student("Charlie", true, 70.0),
            new Student("David", true, 0.0),
            new Student("Eve", false, 80.0)
    );

    private static void outData() {
        listStudent.forEach(a -> {
            System.out.println("Name: " + a.getName());
            System.out.println("Gender: " + (a.getGender() ? "Male" : "Female"));
            System.out.println("Marks: " + a.getMarks());
            System.out.println("----------");
        });
    }

    public static void main(String[] args) {
        demo1();
        System.out.println("==========");
        demo2();
        System.out.println("==========");
        demo3();
    }

    private static void demo1() {
        Stream<Integer> stream = Stream.of(1, 9, 4, 7, 5, 2);
        stream.forEach(System.out::println);
        System.out.println("---");
        List<Integer> list = List.of(1, 9, 4, 7, 5, 2);
        list.stream().forEach(System.out::println);
    }

    private static void demo2() {
        List<Integer> list = List.of(1, 9, 4, 7, 5, 2);
        List<Double> result = list.stream()
                .filter(a -> a % 2 == 0)
                .map(a -> Math.sqrt(a))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static void demo3() {
        List<Student> result = listStudent.stream()
                .filter(a -> a.getMarks() >= 80)
                .peek(a -> a.setName(a.getName().toUpperCase()))
                .sorted((a, b) -> -a.getMarks().compareTo(b.getMarks()))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
