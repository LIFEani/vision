package org.example;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import com.alibaba.excel.EasyExcel;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args){
        T1();
    }
    public static void T1() {
        List<Student> studentList = Arrays.asList(
                new Student("A", 10, "A-os","A-pas","At-txt",new Date()),
                new Student("B", 34, "Bt-os","B-pas","Bt-txt",new Date()),
                new Student("C", 24, "Ct-os","C-pas","Ct-txt",new Date()),
                new Student("D", 42, "Dt-os","D-pas","Dt-txt",new Date()),
                new Student("E", 15, "Et-os","E-pas","Et-txt",new Date()),
                new Student("F", 52, "Ft-os","F-pas","Ft-txt",new Date())
        );
        T2(studentList, "src/main/resources/test.xls");
    }
    public static <T> void T2(List<T> dataList, String fileName) {
//        // 注意：在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照方法2，重复多次写入。
//        // 方法1: 一次写到同一个sheet
//        EasyExcel.write(fileName)
//                .head(Student.class)
//                .sheet()
//                .doWrite(dataList);

        // 方法2: 多次写到同多个sheet
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, Student.class).build()) {
            WriteSheet writeSheet1 = EasyExcel.writerSheet("sheet01").build();
            WriteSheet writeSheet2 = EasyExcel.writerSheet("sheet02").build();

            int batchSize = 2;
            for (int i = 0; i < dataList.size(); i+= batchSize) {
                List<T> demoDataList = dataList.subList(i, Math.min(i + batchSize, dataList.size()));
                excelWriter.write(demoDataList, writeSheet1);
            }
            for (int i = 0; i < dataList.size(); i+= batchSize) {
                List<T> demoDataList = dataList.subList(i, Math.min(i + batchSize, dataList.size()));
                excelWriter.write(demoDataList, writeSheet2);
            }
        }
    }
}









