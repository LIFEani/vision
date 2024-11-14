package org.example;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadListener extends AnalysisEventListener<Map<Integer, Object>>{
    //每行数据-Object形态
    private final List<Map<Integer, Object>> rowMapLists = new ArrayList<>();
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext analysisContext) {
        System.out.println("表头检查执行了");
        System.out.println("headMap = " + JSON.toJSONString(headMap));
        System.out.println("AnalysisContext = " + JSON.toJSONString(analysisContext));
        System.out.println("表头检查结束了");
    }
    @Override
    public void invoke(Map<Integer, Object> rowData, AnalysisContext analysisContext) {
        System.out.println("第" + analysisContext.getCurrentRowNum() + "行扫描开始了");
        System.out.println(JSON.toJSONString(rowData));
        System.out.println(JSON.toJSONString(analysisContext));
        rowMapLists.add(rowData);
        System.out.println("第" + analysisContext.getCurrentRowNum() + "行扫描结束了");
    }
    @Override
    public void onException(Exception exception, AnalysisContext analysisContext) {
        System.out.printf("Excel 文件读取出现异常，行号: %s , 错误原因 %s", analysisContext.getCurrentRowNum(), exception);
        System.out.println("analysisContext = " + JSON.toJSONString(analysisContext));
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("结束处理开始了");
        System.out.println("analysisContext = " + JSON.toJSONString(analysisContext));
        System.out.println("结束处理结束了");
    }
    public List<Map<Integer, Object>> getRowMapLists() {
        return rowMapLists;
    }
}