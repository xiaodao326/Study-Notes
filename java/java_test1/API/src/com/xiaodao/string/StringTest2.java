package com.xiaodao.string;

import java.util.Random;

public class StringTest2 {
    public static void main(String[] args) {
        System.out.println(createCode(4));
        System.out.println(createCode(6));
    }
    /** 1. 实际一个方法，返回指定位数的验证码*/
    public static String createCode(int n) {
        // 2. 定义两个变量一个记住最终产生的验证码，一个记录能用到的全部字符
        String code = "";
        String data = "abcdefghijklmnopqresuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // 3. 定义一个循环产生每位随机字符
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            // 4. 随机一个字符范围类的索引
            int index = r.nextInt(data.length());
            // 5. 根据索引去全部字符中提取字符
            code += data.charAt(index);
        }
        return code;
    }
}
