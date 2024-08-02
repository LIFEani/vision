package org.example;

import com.alibaba.fastjson.JSONObject;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args)  {

        List<String> list =new ArrayList<String>();
        list.add("a");
        list.add("b");
        Set<String> a = list.stream().filter(t-> "a".equals(t)).filter(t-> "b".equals(t)).collect(Collectors.toSet());
        if (a.size()!=0){
            System.out.println("null");
        } else {
            System.out.println("no");
        }


    }
}









