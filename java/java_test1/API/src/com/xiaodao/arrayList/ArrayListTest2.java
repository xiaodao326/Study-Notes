package com.xiaodao.arrayList;

import java.util.ArrayList;

public class ArrayListTest2 {
    public static void main(String[] args) {
        // 目标： 完成拓展案例：商家菜品商家操作
        // 1. 设计一个菜品类Food 负责创建菜品对象，封装菜品数据
        // 2. 设计一个菜品操作类，FoodOperator，负责完成对菜品的业务实现：上架，浏览信息
        FoodOperator operator = new FoodOperator();
        operator.start();
    }
}
