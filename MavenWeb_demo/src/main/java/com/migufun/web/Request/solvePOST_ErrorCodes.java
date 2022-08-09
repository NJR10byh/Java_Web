package com.migufun.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NJR10byh
 * @date 2022/8/9 12:19:20
 * @description 解决 POST 方法的中文乱码问题
 */

@WebServlet("/solvePOST")
public class solvePOST_ErrorCodes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决 POST 方法的中文乱码问题
        String username = req.getParameter("username");
        System.out.println("解决乱码后：" + username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST....");
        this.doGet(req, resp);
    }
}
