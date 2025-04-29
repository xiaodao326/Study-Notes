package com.xiaodao.object.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 1. 设计一个电影类
        // 2. 电影操作类
        // 3. 准备电影数据
        Movie[] movies = new Movie[4];
        movies[0] = new Movie(1,"水门桥1",18.9,9.1,"徐克1","吴京1","11万人想看");
        movies[1] = new Movie(2,"水门桥2",28.9,9.2,"徐克2","吴京2","12万人想看");
        movies[2] = new Movie(3,"水门桥3",38.9,9.3,"徐克3","吴京3","13万人想看");
        movies[3] = new Movie(4,"水门桥4",48.9,9.4,"徐克4","吴京4","14万人想看");
        // 4. 创建一个电影操作类的对象接受电影数据并进行处理
        MovieOperator operator= new MovieOperator(movies);
//        operator.printAllMovies();
//        operator.searchMoviesById(3);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==电影信息系统==");
            System.out.println("1、查询全部电影信息");
            System.out.println("2、根据ID查询电影信息");
            System.out.println("请您输入操作命令。");
            int commend = sc.nextInt();
            switch (commend) {
                case 1:
                    // 展示全部信息
                    operator.printAllMovies();
                    break;
                case 2:
                    // 根据ID查询电影信息
                    System.out.println("请您输入id");
                    int id = sc.nextInt();
                    operator.searchMoviesById(id);
                    break;
                default:
                    System.out.println("您输入的信息有问题");
            }
        }
    }
}
