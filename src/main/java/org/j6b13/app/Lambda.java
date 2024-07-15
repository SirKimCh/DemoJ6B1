package org.j6b13.app;

import org.j6b13.bean.Student;

import java.util.*;

public class Lambda {
    static List<Student> listStudent = Arrays.asList(
            new Student("Alice", true, 90.0),
            new Student("Bob", true, 100.0),
            new Student("Charlie", true, 70.0),
            new Student("David", true, 0.0),
            new Student("Eve", false, 80.0)
    );

    public static void main(String[] args) {
        demo1();
        System.out.println("==========");
        demo2();
        System.out.println("==========");
        demo3();
    }

    private static void outData() {
        listStudent.forEach(a -> {
            System.out.println("Name: " + a.getName());
            System.out.println("Gender: " + (a.getGender() ? "Male" : "Female"));
            System.out.println("Marks: " + a.getMarks());
            System.out.println("----------");
        });
    }

    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.forEach(System.out::println);
    }

    private static void demo2() {
        outData();
    }

    public static void demo3() {
        listStudent.sort((a, b) -> -a.getMarks().compareTo(b.getMarks()));
        outData();
    }
}
