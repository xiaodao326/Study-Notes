package com.xiaodao;

import java.util.Random;
import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        // 目标：完成双色球系统的开发
        int[] userNumbers = userSelectNumbers();
        System.out.println("您投注的号码：");
        printArrary(userNumbers);

        int[] luckNumbers = creatLuckNumbers();
        System.out.println("中奖号码：");
        printArrary(luckNumbers);

        judge(userNumbers, luckNumbers);

    }

    public static void printArrary(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }

    /** 1. 设计一个方法让用户投注一组号码 并返回 （前六个是红球号码，最后一个是蓝球号码）*/
    public static int[] userSelectNumbers() {
        // 2. 提前创建一个整型数组 用于存储用户投注的7个号码 （前六个是红球号码，最后一个是蓝球号码）
        int[] numbers = new int[7];
        // numbers = [0, 0, 0, 0, 0, 0, 0]
        //            0  1  2  3  4  5  6

        Scanner sc = new Scanner(System.in);
        // 3. 通过遍历前6个位置 让用户依次投注6给红球号码，存入
        for (int i = 0; i < numbers.length - 1; i++) {
            // i = 0 1 2 3 4 5 6

            while (true) {
                // 4.让用户为当前位置投注一个红球号码 （1-33 不可重复）
                System.out.println("请您输入第" + (i + 1) + "红球号码 (1 ~ 33 之间，不可重复）");
                int number = sc.nextInt();

                // 5. 先判断用户输入的红球号码是否在 1 ~ 33 之间
                if (number < 1 || number > 33) {
                    System.out.println("对不起，您输入的红球号码不在1~33之间");
                }else {
                    // 号码在1~33之间，继续判断号码是否重复了 不重复才能继续
                    if (exist(numbers,number)){
                        // number 当前号码重复了
                        System.out.println("对不起，您当前输入的红球号码之前选择过了，请确认");
                    }else {
                        // number 当前号码没有重复 可以使用了
                        numbers[i] = number;
                        break; // 结束当此投注，结束了死循环
                    }
                }
            }
        }

        // 6. 投注最后一个蓝球号码
        while (true) {
            System.out.println("请您投注蓝球号码 （1 ~ 16）.");
            int number = sc.nextInt();
            if (number < 1 || number > 16) {
                System.out.println("对不起您输入的蓝球号码范围不对");
            }else {
                numbers[6] = number;
                break; // 篮球号码录入成功 结束死循环
            }
        }
        return numbers;
    }

    private static boolean exist(int[] numbers, int number) {
        // 需求： 判断number这个数字是否在numbers[]中存在
        // numbers = [12, 25, 18, 0, 0, 0, 0]
        // number = 25
        for (int i = 0; i < numbers.length; i++) {
            // 性能优化
            if (numbers[i] == 0){
                break;
            }
            // 判断操作
            if (numbers[i] == number) {
                return true; // 重复了
            }
        }
        // number = 26
        return false;
    }

    /** 2. 这是设计一个方法随机一组中奖号码出来（6个红球号码，1个蓝蓝球号码）*/
    public static int[] creatLuckNumbers() {
        // 1. 创建一个整型数组，用于存储7个号码
        int[] numbers = new int[7];

        Random r = new Random();
        // 2. 遍历前6给位置处 依次随机一个红球号码投入（1~33）
        for (int i = 0; i < numbers.length; i++) {
            // i = 0 1 2 3 4 5

            while (true) {
                // 3. 为当前这个位置随机一个红球号码投入 1 ~ 33 ==> -1 ===> (0, 32) + 1
                int number = r.nextInt(32) + 1;


                // 未改善的：
               /* // 4. 判断这个号码是否重复
                if (exist(numbers,number)) {
                    // 说明number 当前号码重复了

                }else {
                    // number 不重复
                    numbers[i] = number;
                    break; // 找到了当前不充分的红球号码了
                }*/


                // 改善后的：
                // 4. 判断这个号码是否重复
                if (!exist(numbers, number)) {
                    // number 不重复
                    numbers[i] = number;
                    break; // 找到了当前不充分的红球号码了
                }
            }
        }

        // 3. 录入一个蓝球号码
        numbers[6] = r.nextInt(16) + 1;
        return numbers;
    }

    /** 3. 设计一个方法用于记录用户的中奖情况*/
    public static void judge(int[] userNumbers,int[]luckNumbers) {
        // userNumbers = [12, 14, 16, 18, 23, 26 ,8]
        // luckNumbers = [16, 17, 18, 19, 26, 32 ,8]

        // 2。分别定义两个变量 用于记录红球命中了几个 用于记录蓝球是否命中
        int redCount = 0;
        int blueCount = 0;

        // 先判断红球命中的数量
        // 首先遍历用户投注号码的前六个红球
        for (int i = 0; i < userNumbers.length - 1; i++) {
            // userNumbers[i]
            // 开始遍历中奖号码的前六个号码 看用户当前选择的号码是否命中了
            for (int j = 0; j < luckNumbers.length - 1; j++) {
                if (userNumbers[i] == luckNumbers[j]) {
                    redCount++;
                    break;
                }
            }
        }

        // 3. 判断蓝球是否命中
        blueCount = userNumbers[6] == luckNumbers[6] ? 1 : 0;

        System.out.println("您命中的红球数量是：" + redCount);
        System.out.println("您命中的蓝球数量是：" + blueCount);

        // 4. 判断中奖详情 并输出结果
        if (redCount == 6 && blueCount == 1) {
            System.out.println("恭喜您！ 中奖1000万，可以开始享受人生了~~~");
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("恭喜您！ 中奖500万，可以稍微开始享受人生了~~~");
        }else if (redCount == 5 && blueCount == 1) {
            System.out.println("恭喜您！ 中奖3000元，可以出去吃顿小龙虾了~");
        }else if (redCount == 5 && blueCount == 0 || redCount == 4 && blueCount == 1) {
            System.out.println("恭喜您！ 中了小奖，200元~");
        }else if (redCount == 4 && blueCount == 0 || redCount == 3 && blueCount == 1) {
            System.out.println("恭喜您！ 中奖10元~");
        }else if (redCount < 3 && blueCount == 1) {
            System.out.println("恭喜您！ 中奖5元~");
        }else {
            System.out.println("感谢您对福利事业做出的巨大贡献~~~");
        }





    }
}
