package org.example;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

@ColumnWidth(20)   // 列宽，也可以针对每列使用
@HeadRowHeight(25) // 表头行高
@ContentRowHeight(15) // 内容行高
// 头背景设置成红色 IndexedColors.RED.getIndex()
@HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 10)
public class Student {
    @ExcelProperty(value = {"主标题","姓名"}, index = 0)
    @ContentStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 40)
    private String name;//设置表头名, {}, 有一个以上的表头信息时，它会自动合并
    @ExcelProperty(value = {"主标题","年龄"}, index = 1)
    private int age;
    @ColumnWidth(30)   // 列宽
    @ExcelProperty(value = {"主标题","账号"}, index = 2)
    private String account;
    @ExcelIgnore
    private String password;//@ExcelIgnore注解 忽略这个字段
    @ExcelProperty(value = {"主标题", "新增", "备注"}, index = 4)
    private String text;
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty(value = "日期", index = 5)
    @ColumnWidth(30)   // 列宽
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


