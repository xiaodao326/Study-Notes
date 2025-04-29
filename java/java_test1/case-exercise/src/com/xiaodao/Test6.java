package com.xiaodao;

import java.util.Random;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 目标：完成抢红包案例的开发
        int[] moneys = {9, 666, 188, 520, 99999};
        start(moneys);
    }

    public static void start(int[] moneys) {
        // moneys = [9, 666, 188, 520, 99999]
        //           0   1    2    3     4

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        // 1. 定义一个for循环，控制抽奖5次
        for (int i = 1; i <= 5; i++) {
            // 2. 提示粉丝抽奖
            System.out.println("请您输入任意内容进行抽奖：");
            sc.nextLine(); // 等待用户输入内容，按回车再往下走

            while (true) {
                // 3. 为当前粉丝找一个随机红包
                int index = r.nextInt(moneys.length); // 0 ~ 4
                int money = moneys[index];

                // 4. 判断这个红包是否不为0
                if (money != 0) {
                    System.out.println("恭喜您，抽中了红包" + money);
                    moneys[index] = 0;
                    break; // 结束这次抽奖
                }
            }
        }
        System.out.println("活动结束。。");
    }
}