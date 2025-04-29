package com.xiaodao.string;

import java.util.Scanner;

/** 完成用户登陆案例*/

public class StringTest1 {
    public static void main(String[] args) {
        // 1. 开发一个登陆页面
        for (int i = 0 ; i < 3 ; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请您输入登录名称");
            String loginName = sc.next();
            System.out.println("请您输入登录密码");
            String password = sc.next();

            // 5. 开始调用登录方法，判断是否登录成功
            boolean rs = login(loginName, password);
            if (rs) {
                System.out.println("恭喜您，登陆成功");
                break;
            }else {
                System.out.println("登录名或密码错误请您确认");
            }
        }
    }

    /** 2. 开发一个登陆方法，接收用户登录名称和密码，返回认证的结果*/
    public static boolean login(String loginName, String password) {
        // 3. 准备一份正确的登录名和密码
        String okLoginName = "xiaodao";
        String okPassword = "123456";

        // 4. 开始正式判断用户是否登录成功
//        if (okLoginName.equals(loginName) && okPassword.equals(password)) {
//            // 登录成功
//            return true;
//        }else {
//            return false;
//          }
        return okLoginName.equals(loginName) && okPassword.equals(password);
    }
}


