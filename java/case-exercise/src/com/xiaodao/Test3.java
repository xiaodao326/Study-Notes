package com.xiaodao;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        // 目标：完成评委打分案例
        System.out.println("当前选手得分是：" + getAverageScore(6));
    }
    public static double getAverageScore (int number){
        // 1.定义一个动态初始化的数组，负责后期存入评委的打分
        int[] scores = new int[number];// 6
        // scores = [0, 0, 0, 0, 0, 0]

        // 2.遍历数组的每个位置，依次录入评委的分数
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            // i = 0 1 2 3 4 5
            System.out.println("请您录入第"+ (i + 1) +"评委的分数：");
            int score = sc.nextInt();
            scores[i] = score;
        }

        // 3.从数组中计算出总分，找出最高分、最低分
        int sum = 0; // 求总分用的变量
        int max = scores[0]; // 求最大值的变量
        int min = scores[0]; // 求最小值的变量

        // 遍历数组找出这些数据
        for (int i = 0; i < scores.length; i++) {
            // i = 0 1 2 3 4 5
            int score = scores[i];
            // 求和
            sum += score; //sum = sum + score;
            // 求最大值
            if (score > max) {
                max = score;
            }
            // 求最小值
            if (score < min) {
                min = score;
            }
        }
        return 1.0 * (sum - min -max) / (number - 2);
    }
}
