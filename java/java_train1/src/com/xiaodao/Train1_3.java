package com.xiaodao;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class Train1_3 {
    public static void main(String[] args) {
        // 在1~100中随机生成20个数值并存放进numbers数组中
        int[] numbers = new Random().ints(20, 1, 100).toArray();

        // 冒泡排序
        int[] bubble = numbers.clone();
        long startTime = System.nanoTime();
        bubbleSort(bubble);
        long endTime = System.nanoTime();
        System.out.println("冒泡排序结果为" + Arrays.toString(bubble));
        System.out.println("耗时" + (endTime - startTime) + "纳秒");

        // 二叉树排序
        TreeSet<Integer> set = new TreeSet<>();
        startTime = System.nanoTime();
        for (int num : numbers) set.add(num);
        endTime = System.nanoTime();
        System.out.println("二叉树排序结果为" + set);
        System.out.println("耗时" + (endTime - startTime) + "纳秒");

        // 插入排序
        int[] insert = numbers.clone();
        startTime = System.nanoTime();
        insertSort(insert);
        endTime = System.nanoTime();
        System.out.println("插入排序结果为" + Arrays.toString(insert));
        System.out.println("耗时" + (endTime - startTime) + "纳秒");
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

}
