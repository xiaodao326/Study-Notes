package com.xiaodao;

import java.util.List;

public class Train1_2 {
    public static void main(String[] args) {
        // 1. 获取用户输入的年月日
        List<String> dateList = InputDateStream.input();

        // 2. 计算时间
        dateList.stream()
                .map(date -> {
                    long days = CalculateDaysToToday.CountDay(date);
                    return "日期" + date + "至今" + days + "天";
                })
                // 3. 打印计算结果
                .forEach(System.out::println);
    }
}