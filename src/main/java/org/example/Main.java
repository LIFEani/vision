package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.time.Instant;
import java.util.*;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "John");
        jsonObject.put("age", 30);

        System.out.println(JSON.toJSONString(jsonObject));



    }
}









