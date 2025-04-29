package com.xiaodao;

import java.util.Scanner;

public class InputDate {
    public static String Input() {
        Scanner sc = new Scanner(System.in);
        String data ="";
        while (true) {
            System.out.println("请输入出生日期（格式：yyyy-mm-dd）:");
            data = sc.nextLine();

            // 1.1用户输入检测
            if (data.length() != 10) {
                System.out.println("您输入的日期格式有问题，请重新输入");
            } else {
                return data;// 输入正确，退出循环
            }
        }
    }
}
