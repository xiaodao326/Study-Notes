package com.xiaodao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        //1111111000

        //抽0或1
        // 1.创建集合
        List<Integer> list = new ArrayList<>();
        // 2.添加数据
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        // 3.打乱数据
        Collections.shuffle(list);
//        System.out.println(list);
        // 4.从list中抽取0或1
        Random r = new Random();
        int index = r.nextInt(list.size());
        int number = list.get(index);
        System.out.println(number);

        // 5.创建两个集合分别存储男生和女生的名字
        ArrayList<String>boyList = new ArrayList<>();
        ArrayList<String>girlList = new ArrayList<>();

        Collections.addAll(boyList, "zyx", "yw", "lhy","pxj", "zqc","lxy");
        Collections.addAll(girlList, "hys", "ty","gyx", "wlj");

        // 6.判断从boyList 还是从girlList抽取
        if (number == 1){
            // boyList
            int boyIndex = r.nextInt(boyList.size());
            String name = boyList.get(boyIndex);
            System.out.println(name);
        }else {
            //girlList
            int girlIndex = r.nextInt(girlList.size());
            String name = girlList.get(girlIndex);
            System.out.println(name);
        }
    }
}
