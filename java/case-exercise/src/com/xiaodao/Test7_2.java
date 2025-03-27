package com.xiaodao;

public class Test7_2 {
    public static void main(String[] args) {
        // 目标：完成找素数
        System.out.println("当前素数个数是：" + search(101, 200));
    }
    public static int search(int start, int end){
        int count = 0;
        // start = 101    end = 200
        OUT: // 为外部循环指定标签
        for (int i = start; i <=end ; i++) {
           // i = 101 102 103 ... 200
            // 2. 拦截判断当前i记住的数据是否是素数
            for (int j = 2; j <= i/2 ; j++) {
                if (i % j == 0){
                    // 肯定不是素数 不能打印
                    continue OUT;// 结束外部循环的当次执行
                }
            }
            // 3. 根据判断的结果决定是否输出当前记住的数据（素数才展示）
            System.out.println(i);
            count++;
        }
        return count;
    }
}
