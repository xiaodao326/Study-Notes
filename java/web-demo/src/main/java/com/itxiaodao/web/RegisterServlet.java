package com.itxiaodao.web;

import com.itxiaodao.mapper.UserMapper;
import com.itxiaodao.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/web-demo/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.封装
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //2.调用mybatis完成查询
        String resource = "mybatis-config.xml";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User u = userMapper.selectByUsername(username);

        //3.判断
        if (u == null) {
            userMapper.add(user);

            sqlSession.commit();
            sqlSession.close();

            //注册成功，自动登录
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 注册成功，重定向到登录页
            response.sendRedirect(request.getContextPath() + "/login.html");
            System.out.println("注册成功");
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(
                    "<script>alert('用户名已存在！'); window.location.href='" +
                            request.getContextPath() + "/register.html';</script>"
            );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
