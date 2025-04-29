package com.xiaodao.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *菜品操作类：负责上架和浏览功能的实现
 * */
public class FoodOperator {
    // 1. 定义一个ArrayList集合对象，负责存储菜品信息
    private ArrayList<Food> foodList = new ArrayList<>();
    // foodList = []

    // 2.开发功能，上架菜品功能
    public void addFood() {
        // 3. 创建一个菜品对象封装双加的菜品信息
        Food f = new Food();

        // 4. 录入菜品信息进去
        Scanner sc = new Scanner(System.in);

        System.out.println("请您输入该菜品名称");
        String name = sc.next();
        f.setName(name);

        System.out.println("请您输入该菜品价格");
        double price = sc.nextDouble();
        f.setPrice(price);

        System.out.println("请您输入该菜品详情");
        String desc = sc.next();
        f.setDesc(desc);


        // 5. 把菜品对象存入集合中
        foodList.add(f);
        System.out.println("上架成功");
    }

    // 3，展示信息
    // foodList = [ f1, f2, f3]
    public void shoAllFoods() {
        if (foodList.size() == 0) {
            System.out.println("什么菜品都没有，先去上架！");
            return;
        }
        for (int i = 0; i < foodList.size(); i++) {
            Food f = foodList.get(i);
            System.out.println(f.getName());
            System.out.println(f.getPrice());
            System.out.println(f.getDesc());
            System.out.println("--------------------");
        }
    }

    /** 负责展示操作界面*/
    public void start() {
        while (true) {
            System.out.println("请选择功能");
            System.out.println("1.上架菜品");
            System.out.println("2.展示菜品");
            System.out.println("3.退出");

            Scanner sc = new Scanner(System.in);
            System.out.println("请选择您的操作");
            String command = sc.next();
            switch (command) {
                case "1":
                    addFood();
                    break;
                case "2":
                   shoAllFoods();
                   break;
                case "3":
                    System.out.println("下次再来偶");
                    return;
                default:
                    System.out.println("您输入的命令不存在");
            }
        }
    }
}
