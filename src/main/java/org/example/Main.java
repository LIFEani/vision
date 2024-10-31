package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args){
        List<Student> studentList = Arrays.asList(
                new Student("A", 10, "At-txt"),
                new Student("B", 34, "Bt-txt"),
                new Student("C", 24, "Ct-txt"),
                new Student("D", 42, "Dt-txt"),
                new Student("E", 15, "Et-txt"),
                new Student("F", 52, "Ft-txt")
        );
        studentList.stream().flatMap(p -> Stream.of(p.getName(), p.getText())).forEach(System.out::println);


    }
}









