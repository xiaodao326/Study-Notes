package com.xiaodao.object.demo;

public class MovieOperator {
    private Movie[] movies;
    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    /** 1. 展示全部电影信息 movies = [m1, m2, m3, ...]*/
    public void printAllMovies() {
        System.out.println("-----电影全部信息如下-----");
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            System.out.println("编号" + m.getId());
            System.out.println("名称" + m.getName());
            System.out.println("价格" + m.getPrice());
            System.out.println("-------------------------");
        }
    }

    /** 2. 根据电影的编号详情的展示电影信息*/
    public void searchMoviesById(int id) {
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            if (m.getId() == id) {
                System.out.println("该电影详情如下");
                System.out.println("编号" + m.getId());
                System.out.println("名称" + m.getName());
                System.out.println("价格" + m.getPrice());
                System.out.println("得分" + m.getScore());
                System.out.println("导演" + m.getDirector());
                System.out.println("主演" + m.getActor());
                System.out.println("其他信息" + m.getInfo());
                System.out.println("-------------------------");
                return; // 已经找到电影信息 不用再执行了
            }
        }
        System.out.println("没有该电影信息~");
    }
}
