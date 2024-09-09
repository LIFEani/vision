package org.example;


import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private String text;

    public Student(String name, int age, String text) {
        this.name = name;
        this.age = age;
        this.text = text;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", text='" + text + '\'' +
                '}';
    }
}


