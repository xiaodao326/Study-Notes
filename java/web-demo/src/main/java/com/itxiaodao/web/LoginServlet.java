package com.itxiaodao.web;

import com.itxiaodao.mapper.UserMapper;
import com.itxiaodao.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/web-demo/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        //2.调用mybatis完成查询
        String resource = "mybatis-config.xml";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username, password);
        sqlSession.close();

        //获取字符输出流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //3.判断user是否为null
        if (user != null) {
            //登录成功，设置session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if ("on".equals(remember)) {
                //选择记住我
                //1.创建cookie
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);

                //2.设置Cookie有效期
                usernameCookie.setMaxAge(60 * 60 * 24 * 7);
                passwordCookie.setMaxAge(60 * 60 * 24 * 7);

                //3.设置Cookie路径
                usernameCookie.setPath("/");
                passwordCookie.setPath("/");

                //4.发送Cookie给客户端
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);

                //测试
                System.out.println("Remember me value: " + remember);
                System.out.println("Creating cookies for username: " + username);
            }else {
                //未选择记住我
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("username")|| cookie.getName().equals("password")) {
                            cookie.setMaxAge(0);
                            cookie.setPath(request.getContextPath());
                            response.addCookie(cookie);
                        }
                    }
                }
            }

            // 登录成功，重定向到主页或其他页面
            response.sendRedirect(request.getContextPath() + "/html/index1.html");
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(
                    "<script>alert('登录失败'); window.location.href='" +
                            request.getContextPath() + "/login.html';</script>"
            );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
