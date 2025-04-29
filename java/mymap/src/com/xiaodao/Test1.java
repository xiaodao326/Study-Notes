package com.xiaodao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        // 1.定义集合
        List<String> list = new ArrayList<>();
        // 2.添加数据
        Collections.addAll(list, "zyx", "yw", "hys", "ty", "lhy","pxj", "zqc","lxy");
        // 3.随机点名
//        Random r = new Random();
//        // 10 0~9
//        int index = r.nextInt(list.size());
//        String name = list.get(index);
//        System.out.println(name);

        // 打乱集合数据
        Collections.shuffle(list);
        String name = list.get(0);
        System.out.println(name);

    }
}
