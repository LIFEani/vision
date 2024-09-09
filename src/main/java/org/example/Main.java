package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Student s1 = new Student("Ram", 18, "Ram-18-worktext");
        Student s2 = new Student("Shyam", 22, "Shyam-22-worktext");
        Student s3 = new Student("Mohan", 19, "Mohan-19-worktext");
        Student s4 = new Student("Alice", 20, "Alice-20-worktext");
        Student s5 = new Student("Bob", 21, "Bob-21-worktext");
        Student s6 = new Student("Cindy", 17, "Cindy-17-worktext");
        Student s7 = new Student("David", 23, "David-23-worktext");
        Student s8 = new Student("Eve", 16, "Eve-16-worktext");
        Student s9 = new Student("Frank", 24, "Frank-24-worktext");
        Student s10 = new Student("Grace", 15, "Grace-15-worktext");
        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);

        //start
        Optional<Student> student = list.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .findFirst();
        if (student.isPresent()) {
            student.get().setText("studenttext");
        }

        List<Student> updatedList = list.stream()
                .map(t -> {
                    if (t.getText().equals("studying")) {
                        return t;
                    } else {
                        t.setText("working");
                        return t;
                    }
                })
                .collect(Collectors.toList());
        System.out.println(updatedList);
    }
}









