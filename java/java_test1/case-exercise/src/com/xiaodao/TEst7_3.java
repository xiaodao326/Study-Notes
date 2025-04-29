package com.xiaodao;

public class TEst7_3 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i <= 200 ; i++) {
            // i = 101 102 103 ,,, 200
            // i遍历到得当前数据是否是素数 是就输出 不是不输出
            if (check(i)){
                System.out.println(i);
                count++;
            }
        }
        System.out.println("素数个数为：" + count);
    }
    public static boolean check(int data){
        for (int i = 2; i <= data / 2 ; i++) {
            if (data % i == 0) {
                return false; // 不是素数
            }
        }
        return true;
    }
}
