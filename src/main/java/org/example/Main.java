package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args)  {

        // 创建一个新的 JSONObject 实例
        JSONObject jsonObject = new JSONObject();

        // 向 JSONObject 中添加数据
        jsonObject.put("name", "张三");
        jsonObject.put("age", 30);
        jsonObject.put("isStudent", false);

        // 嵌套一个 JSONObject
        JSONObject address = new JSONObject();
        address.put("city", "北京");
        address.put("district", "海淀区");

        // 将嵌套的 JSONObject 添加到主 JSONObject 中
        jsonObject.put("address", address);




        System.out.println(jsonObject.getString("isStudent"));

        System.out.println("false".equals(jsonObject.getString("isStudent")));

    }
}









