package com.migufun.web.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author NJR10byh
 * @date 2022/8/10 16:22:39
 * @description 获取Session
 */

@WebServlet("/sessionDemo2")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取Session对象
        HttpSession session = req.getSession();

        resp.setContentType("text/html;charset=utf-8");

        // 2、存储Session数据
        Object username = session.getAttribute("username");
        System.out.println(username);

        PrintWriter writer = resp.getWriter();
        writer.write(username.toString());
        
        // Session自主销毁
        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
