package com.itxiaodao.web;

import com.itxiaodao.mapper.UserMapper;
import com.itxiaodao.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI().substring(request.getContextPath().length());

        // 排除登录、注册和静态资源
//        if (path.startsWith("/login.html") ||
//                path.startsWith("/register.html") ||
//                path.startsWith("/css/") ||
//                path.startsWith("/js/") ||
//                path.startsWith("/imgs/")) {
//            filterChain.doFilter(request, response);
//            return;
//        }

        //检查是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            //检查是否有用于登陆的Cookie
            Cookie[] cookies = request.getCookies();
            String username = null;
            String password = null;

            //测试
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    System.out.println("Found cookie: " + cookie.getName() + "=" + cookie.getValue());
                }
            }

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = cookie.getValue();
                        System.out.println("Found username: " + username);
                    }
                    if (cookie.getName().equals("password")) {
                        password = cookie.getValue();
                        System.out.println("Found password: " + password);
                    }
                }
            }

            //有Cookie尝试自动登录
            if (username != null && password != null) {
                String resourse = "mybatis-config.xml";
                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourse);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                SqlSession sqlSession = sqlSessionFactory.openSession();
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                User autoLoginUser = userMapper.selectByUsername(username);

                if (autoLoginUser != null && autoLoginUser.getPassword().equals(password)) {
                    session.setAttribute("user", autoLoginUser);
                    System.out.println("自动登录成功" + username);
                    sqlSession.commit();
                    sqlSession.close();

                    //禁用缓存
                    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Expires", "0");

                    // 自动登录成功后重定向到主页
                    response.sendRedirect(request.getContextPath() + "/html/index1.html");
                    System.out.println("已跳转");
                    return;
                }
            }

            System.out.println("打回登录页");
            // 如果自动登录失败，且访问的是需要登录的页面（如 index1.html），则跳转到登录页
//            if (path.startsWith("/html/index1.html")) {
//                response.sendRedirect(request.getContextPath() + "/login.html");
//                System.out.println("跳转登录页");
//                return;
//            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
