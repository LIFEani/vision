package org.example;

import com.alibaba.fastjson.JSONObject;

import java.time.Instant;
import java.util.*;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        long a = Instant.now().toEpochMilli();
        Thread.sleep(1000L);
        long b = Instant.now().toEpochMilli();

        System.out.println( b-a  );
        System.out.println("...............");



    }
}









