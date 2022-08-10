package com.migufun.web.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author NJR10byh
 * @date 2022/8/10 15:31:13
 * @description Cookie的发送
 */

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 发送Cookie
        String value = "张三";
        // Cookie传输中文，需要进行URL编解码
        value = URLEncoder.encode(value, "UTF-8");
        Cookie cookie = new Cookie("username", value);
        cookie.setMaxAge(60 * 60 * 24 * 1);// Cookie一天到期
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
