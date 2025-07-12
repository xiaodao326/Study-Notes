package com.itxiaodao.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet
public class MyHttpServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 根据请求方式不同，进行分别的处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 1.获取请求方式
        String method = request.getMethod();
        // 2.判断
        ServletResponse res;

        ServletRequest req;
        if ("GET".equals(method)) {
            // get方式的处理逻辑
//            doGet(req,res);
        }else if ("POST".equals(method)) {
            // post方式的处理逻辑
//            doPost(req,res);
        }
    }

    protected void doGet(ServletRequest req, ServletResponse res) {

    }

    protected void doPost(ServletRequest req, ServletResponse res) {

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
