package com.migufun.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author NJR10byh
 * @date 2022/8/9 10:18:36
 * @description 通用方法获取请求参数
 */

@WebServlet("/req_map")
public class RequestDemo_Map extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET.....");
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.print(key + ":");
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("----------------");
        String[] hobbies = req.getParameterValues("hobby");
        for (String value : hobbies) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println("----------------");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST.....");
        this.doGet(req, resp);
    }
}
