## 题目：

- 随机生成20个数字（随机种子），分别使用冒泡排序、插入排序、二叉树排序进行排序，并输出最终结果以及三种排序使用的时间

## 代码：

```JAVA
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
```

## 实现思路：

- 生成用于排序的随机20个数字->单独生成2函数方法写出代码分别实现冒泡排序、插入排序->根据题目选择合适的二叉树对数据进行排序->用获取时间的方法在每次调用方法进行排序的前后包上->后再输出排序结果和所需的时间

## 感悟：

- 刚开始时完成代码输出结果中三个排序算法耗时均为0s，在检查代码实现逻辑没问题后上网寻求帮助最终借助AI帮我排除bug
- currentTimeMillis 方法所记录的时间最低为秒，而三个算法耗时均少于1s所以导致第一次输出结果为0s
- 适当借助AI学习可以帮助我补充陌生知识点