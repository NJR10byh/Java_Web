package com.migufun.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author NJR10byh
 * @date 2022/8/9 09:23:10
 * @description 获取请求数据
 */

@WebServlet("/req1")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method); // GET

        String contextPath = req.getContextPath();
        System.out.println(contextPath); // /MavenWeb_demo_war

        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL); // http://localhost:8000/MavenWeb_demo_war/req1

        String requestURI = req.getRequestURI();
        System.out.println(requestURI); // /MavenWeb_demo_war/req1

        String queryString = req.getQueryString();
        System.out.println(queryString); // username=zhangsan&password=123

        String header = req.getHeader("user-agent");
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader breader = req.getReader();
        String s = breader.readLine();
        System.out.println(s);
    }
}
