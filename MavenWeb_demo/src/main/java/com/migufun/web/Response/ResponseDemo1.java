package com.migufun.web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NJR10byh
 * @date 2022/8/9 14:23:42
 * @description
 */

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1....");

        // 重定向
        // 1、设置响应状态码 302
        // resp.setStatus(302);
        // 2、设置响应头 Location
        // resp.setHeader("Location", "/MavenWeb_demo_war/resp2");

        // 动态获取虚拟目录
        // req.getContextPath();
        // 简化方式完成重定向
        resp.sendRedirect(req.getContextPath() + "/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
