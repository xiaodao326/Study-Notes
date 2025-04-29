package com.xiaodao;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputDateStream {
    public static List<String> input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期(格式：yyyy-mm-dd(可输入多个日期，但多个日期之间请用“,”做分割)):");
        String date = sc.nextLine();
        return Arrays.stream(date.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
