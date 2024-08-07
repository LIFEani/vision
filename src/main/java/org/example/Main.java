package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args)  {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("key0", "value00");
                put("key1", "value01");
            }});
            add(new HashMap<String, String>() {{
                put("key0", "value10");
                put("key1", "value11");
                put("key2", "value12");
            }});
            add(new HashMap<String, String>() {{
                put("key0", "value20");
                put("key1", "value21");
                put("key2", "value22");
            }});
        }};

        String key0 = null;
        String key1 = null;

        Set<String> collect = list.stream()
                .filter(t-> StringUtils.isNotEmpty(key0) ? key0.equals(t.get("key0")) : true)
                .filter(t-> StringUtils.isNotEmpty(key1) ? key1.equals(t.get("key1")) : true)
                .flatMap(i -> Stream.of(i.get("key0"), i.get("key2")))
                .filter(Objects::nonNull) // 过滤掉 null 值
                .collect(Collectors.toSet());
        System.out.println(collect);
    }
}









