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
import org.apache.poi.ss.usermodel.*;

import java.util.*;

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
        List<List<Object>> resultList = new ArrayList<>();
        // 遍历Student列表进行转换
        for (Student student : studentList) {
            List<Object> innerList = new ArrayList<>();
            innerList.add(student.getName());
            innerList.add(student.getAge());
            innerList.add(student.getAccount());
            innerList.add(student.getPassword());
            innerList.add(student.getText());
            innerList.add(student.getBirthday());
            resultList.add(innerList);
        }
        T2(resultList, "src/main/resources/test.xls");
    }
    public static <T> void T2(List<T> dataList, String fileName) {
        try {
            // 创建ExcelWriter构建器，指定要生成的Excel文件路径
            ExcelWriterBuilder builder = EasyExcel.write(fileName);
            // 配置ExcelWriter相关属性
            ExcelWriter excelWriter = builder.excelType(ExcelTypeEnum.XLS)
                    .inMemory(true)
                    .autoCloseStream(true)
                    .build();

            // 获取表头
            List<List<String>> head = getLists();

            // 创建工作表构建器，指定工作表索引为0（第一个工作表），名称为"用户信息表"
            ExcelWriterSheetBuilder writer = EasyExcel.writerSheet(0, "用户信息表")
                    .head(head);

            // 创建表头单元格的WriteCellStyle对象
            WriteCellStyle headCellStyle = new WriteCellStyle();
            // 设置表头单元格水平对齐方式为居中对齐
            headCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            // 设置表头单元格垂直对齐方式为居中对齐
            headCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            // 设置表头单元格边框样式
            setBorderStyle(headCellStyle);

            // 创建内容单元格的WriteCellStyle对象
            WriteCellStyle contentCellStyle = new WriteCellStyle();
            // 设置内容单元格水平对齐方式为左对齐
            contentCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
            // 设置内容单元格垂直对齐方式为居中对齐
            contentCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            // 设置内容单元格边框样式
            setBorderStyle(contentCellStyle);

            // 创建HorizontalCellStyleStrategy对象，传入正确的表头和内容单元格的样式对象
            HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headCellStyle, contentCellStyle);

            // 注册样式策略到工作表构建器
            writer.registerWriteHandler(horizontalCellStyleStrategy);

            // 构建工作表
            WriteSheet sheetObj = writer.build();

            // 检查数据与表头是否匹配
            checkDataAndHeadMatch(dataList, head);

            // 写入数据到工作表
            excelWriter.write(dataList, sheetObj);

            // 关闭ExcelWriter，释放相关资源
            excelWriter.finish();
        } catch (Exception e) {
            // 捕获并打印可能出现的异常，方便排查问题
            e.printStackTrace();
        }
    }

    // 设置字体样式的方法
    private static Font setFontStyle(Workbook workbook, String fontName, short fontSize, boolean isBold) {
        Font font = workbook.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontSize);
        font.setBold(isBold);
        return font;
    }

    // 设置边框样式的方法
    private static void setBorderStyle(WriteCellStyle cellStyle) {
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
    }

    // 检查数据与表头是否匹配的方法
    private static void checkDataAndHeadMatch(List<?> dataList, List<List<String>> head) {
        if (dataList == null || dataList.isEmpty()) {
            System.out.println("数据列表为空，请检查数据来源是否正确。");
            return;
        }
        if (head == null || head.isEmpty()) {
            System.out.println("表头数据为空，请检查表头获取逻辑。");
            return;
        }
        int headColumnCount = head.size();
        Object firstData = dataList.get(0);
        if (firstData instanceof List) {
            List<?> firstDataList = (List<?>) firstData;
            if (firstDataList.size()!= headColumnCount) {
                System.out.println("数据列数与表头列数不匹配，请检查数据结构与表头的一致性。目前表头列数" + headColumnCount + "数据列数" + firstDataList.size());
            }
        } else {
            System.out.println("数据格式不符合预期，期望是List类型的数据，请检查数据来源和格式。目前格式为" + firstData.getClass());
        }
    }

    private static List<List<String>> getLists() {
        List<List<String>> head = new ArrayList<>();
        head.add(Arrays.asList("学生信息","基本信息", "姓名"));
        head.add(Arrays.asList("学生信息","基本信息", "年龄"));
        head.add(Arrays.asList("学生信息","详细信息", "账号"));
        head.add(Arrays.asList("学生信息","详细信息", "密码"));
        head.add(Arrays.asList("学生信息","详细信息", "备注"));
        head.add(Arrays.asList("学生信息","详细信息", "生日"));
        return head;
    }
}









