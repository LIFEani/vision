package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args){

           //T1();
            T2();

    }
    public static void T1(){
        List<Student> studentList = Arrays.asList(
                new Student("A", 10, "At-txt",new Date()),
                new Student("B", 34, "Bt-txt",new Date())
        );
        String jsonString = JSON.toJSONString(studentList);
        System.out.println(jsonString);
    }
    public static void T2(){
        String a = "[{\"age\":10,\"birthday\":\"null\",\"name\":\"A\",\"text\":\"At-txt\"},{\"age\":34,\"birthday\":\"2024-11-06 11:29:40\",\"name\":\"B\",\"text\":\"Bt-txt\"}]";
        List<Student> students = JSON.parseArray(a, Student.class);
        System.out.println(JSON.toJSONString(students));
    }

}









