package org.example;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        T1();
    }
    public static void T1() {
        // 创建一个包含多个学生对象的不可变列表
        List<Student> studentList = Arrays.asList(
                new Student("A", 10, "2024-04-11"),
                new Student("A", 34, "2024-04-12"),
                new Student("A", 24, "2024-04-13"),
                new Student("D", 42, "2024-04-14"),
                new Student("D", 15, "2024-04-15"),
                new Student("D", 52, "2024-04-16")
        );

        // 定义比较器Comparator，用于按照日期属性进行排序
        // 比较逻辑是将两个学生对象对应的日期字符串解析为LocalDate类型后进行比较
        // 返回值表示比较结果，用于确定排序顺序，这里实现的是降序排序（日期靠后的在前）
        Comparator<Student> dateComp = (s1, s2) -> {
            return LocalDate.parse(s2.getText()).compareTo(LocalDate.parse(s1.getText()));
        };

        // 按照日期属性对学生列表进行排序，并收集为新的列表后输出
        // 首先通过stream()方法获取流，然后使用sorted()方法结合定义好的比较器dateComp进行排序
        // 最后使用collect()方法将排序后的流元素收集为List类型
        List<Student> collect = studentList.stream().sorted(dateComp).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));

        // 按照学生姓名进行分组，并在每组中取日期最大（根据dateComp比较器确定）的学生对象
        // 使用groupingBy()收集器按照学生的姓名进行分组，第一个参数Student::getName表示以学生姓名作为分组的键
        // 第二个参数使用collectingAndThen()对每组的收集结果进一步处理
        // 在collectingAndThen()中，先使用maxBy(dateComp)获取每组中日期最大的学生（返回Optional类型）
        // 再通过Optional -> Optional.orElse(null)处理，如果Optional中有值就返回对应的学生对象，否则返回null
        Map<String, Student> collect2 = studentList.stream().collect(Collectors.groupingBy(Student::getName,
                Collectors.collectingAndThen(
                        Collectors.maxBy(dateComp),
                        Optional -> Optional.orElse(null)
                )));
        System.out.println(JSON.toJSONString(collect2));

        // 按照学生姓名进行分组，并在每组中取日期最大（根据dateComp比较器确定）的学生对象对应的年龄
        // 同样先使用groupingBy()按姓名分组，然后在collectingAndThen()中进行后续处理
        // 这里通过Optional -> Optional.map(Student::getAge).orElse(0)操作
        // 先从每组日期最大的学生（如果存在，通过Optional.map提取年龄属性），如果不存在则返回默认值0
        Map<String, Integer> collect3 = studentList.stream().collect(Collectors.groupingBy(Student::getName,
                Collectors.collectingAndThen(
                        Collectors.maxBy(dateComp),
                        Optional -> Optional.map(Student::getAge).orElse(0)
                )));
        System.out.println(JSON.toJSONString(collect3));
    }
    public static <T> void T2() {

    }
}









