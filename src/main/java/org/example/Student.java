package org.example;


import com.alibaba.fastjson.annotation.JSONField;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private String text;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Student(String name, int age, String text) {
        this.name = name;
        this.age = age;
        this.text = text;
    }

    public Student(String name, int age, String text, Date birthday) {
        this.name = name;
        this.age = age;
        this.text = text;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.birthday = sdf.parse(dateStr);
        } catch (Exception e) {
            this.birthday = null;
        }
    }
}


