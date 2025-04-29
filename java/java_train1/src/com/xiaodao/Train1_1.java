package com.xiaodao;

public class Train1_1 {
    public static void main(String[] args) {
        // 1. 获取用户出生年月日
        /*Scanner sc = new Scanner(System.in);
        String data ="";
        while (true) {
            System.out.println("请输入出生日期（格式：yyyy-mm-dd）:");
            data = sc.nextLine();

            // 1.1用户输入检测
            if (data.length() != 10) {
                System.out.println("您输入的日期格式有问题，请重新输入");
            } else {
                break; // 输入正确，退出循环
            }
        }*/

        String date = InputDate.Input();

/*        // 2. 计算用户生活时间
        LocalDate Birthday = LocalDate.parse(data);
        LocalDate now = LocalDate.now();
        long days = ChronoUnit.DAYS.between(Birthday, now);*/

            long days = CalculateDaysToToday.CountDay(date);

            // 3. 打印计算结果
            System.out.println("您已经在地球online中游玩了" + days + "天");
    }
}
