package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private String name;

    private int age;

    private String account;

    private String password;

    private String text;

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
    public Student(String name, int age, String account, String password, String text, Date birthday) {
        this.name = name;
        this.age = age;
        this.account = account;
        this.password = password;
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
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}


