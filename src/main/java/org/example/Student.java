package org.example;


import java.util.Arrays;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String text;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(String name, String text) {
        this.name = name;
        this.text = text;
    }
    public Student( ) {

    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getText() {
        return text;
    }
    @Override
    public int compareTo(Student s) {
        return name.compareTo(s.getName());
    }
    @Override
    public String toString(){
        return name + "-" + age;
    }
    public static List<Student> getStudentList(){
        Student s1 = new Student("Ram", 18);
        Student s2 = new Student("Shyam",22);
        Student s3 = new Student("Mohan",19);
        List<Student> list = Arrays.asList(s1,s2,s3);
        return list;
    }
}


