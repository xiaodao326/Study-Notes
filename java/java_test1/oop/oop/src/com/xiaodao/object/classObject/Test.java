package com.xiaodao.object.classObject;

public class Test {
    public static void main(String[] args) {
        // 目标： 面向对象编程快速入门
        // 1. 创建一个学生对象，封装波妞的数据
        Student s1 = new Student();
        s1.name = "波妞";
        s1.chinese = 100;
        s1.math = 100;
        s1.printTotalScore();
        s1.printAverageScore();

        // 2. 在创建一个学生对象 封装波仔的数据
        Student s2 = new Student();
        s2.name = "波仔";
        s2.chinese = 59;
        s2.math = 100;
        s2.printTotalScore();
        s2.printAverageScore();
    }
}
