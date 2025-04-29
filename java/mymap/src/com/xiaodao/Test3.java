package com.xiaodao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        // 1.定义集合
        List<String> list1 = new ArrayList<>();
        // 2.添加数据
        Collections.addAll(list1, "zyx", "yw", "hys", "ty", "lhy","pxj", "zqc","lxy");
        // 创建一个临时的集合 用来存储已经被点到名字的学生
        ArrayList<String> list2= new ArrayList<String>();
        for (int j = 1; j <= 10; j++) {
            System.out.println("============第" + j +"轮点名开始了=======================");
            // 3.获取集合长度
            int count = list1.size();
            // 4.随机点名
            Random r = new Random();
            for (int i = 0; i < count; i++) {
                int index = r.nextInt(list1.size());
//        String name = list.get(index);
//        list.remove(index);
                String name = list1.remove(index);
                list2.add(name);
                System.out.println(name);
            }
            // 此时第一轮点名结束
            //list1 空了 list2 10学生姓名
            list1.addAll(list2);
            list2.clear();
        }
    }
}
