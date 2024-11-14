package org.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args){
        T1();
    }
    public static void T1() {
        T2("test.xls", readListener -> {
            System.out.println("----------importBeforeHandle导入后处理逻辑开始----------");
            List<Map<Integer, Object>> lists = readListener.getRowMapLists();
            for (Map<Integer, Object> list : lists) {
                System.out.println(list);
            }
            System.out.println("----------importBeforeHandle导入后处理逻辑结束----------");
        });
    }
    public static void T2(String path, ImportBeforeHandleInterface importBeforeHandle) {
        System.out.println("----------T2导入主程序开始----------");
        ClassPathResource resource = new ClassPathResource(path);
        File file;
        try {
            file = resource.getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ExcelReaderBuilder readerBuilder = EasyExcel.read(file);
        ReadListener readListener = new ReadListener();
        readerBuilder.registerReadListener(readListener);//设置监听器
        readerBuilder.excelType(ExcelTypeEnum.XLS);
        readerBuilder.ignoreEmptyRow(true);//去除空行
        readerBuilder.autoTrim(true);//去除字符串左右空白

        //方法1：可以通过 sheet() 方法指定要读取的特定工作表
        readerBuilder.sheet().doRead();
        //方法2：会读取 Excel 文件中的所有工作表
        //readerBuilder.doReadAll();

        //导入后处理
        importBeforeHandle.handle(readListener);
        System.out.println("----------T2导入主程序结束----------");
    }
}









