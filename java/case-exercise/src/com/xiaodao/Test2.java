package com.xiaodao;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        // 完成生成随机验证码
        System.out.println(creatCode(5));
    }
    public static String creatCode(int n) {
        // 定义一个for循环 用于控制产生多少位随机字符
        Random r = new Random();
        // 3.定义一个String类型的变量，用于记录产生的每位随机字符
        String code = "";
        for (int i = 1; i <= n; i++) {
            // 1. i = 1 2 3 4 5
            // 2. 为每个位置生成一个随机字符
            // 思路： 随机一个0 1 2 之间的数字出来，0代表随机一个数字字符，1、2代表随机大小写字母。
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    // 随机一个数字字符
                    code += r.nextInt(10);// 0~9
                    break;
                case 1:
                    // 随机一个大写字符 A 65   Z 65+25   (0 - 25) + 65
                    char ch1 = (char) (r.nextInt(26) + 65);
                    code += ch1;
                    break;
                case 2:
                    // 随机一个小写字符  a 97   z 97+25   (0 - 25) + 97
                    char ch2 = (char) (r.nextInt(26) + 97);
                    code += ch2;
                    break;
            }
        }
        return code;
    }
}
