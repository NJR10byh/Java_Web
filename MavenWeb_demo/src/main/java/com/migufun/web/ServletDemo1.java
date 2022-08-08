package com.migufun.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author NJR10byh
 * @date 2022/8/8 17:06:33
 * @description
 */

@WebServlet(urlPatterns = "/demo1",loadOnStartup = 1)
public class ServletDemo1 implements Servlet {

    /**
     * @param servletConfig
     * @throws ServletException
     *
     * 初始化方法：默认情况下，Servlet第一次被访问时调用
     * loadOnStartup：
     *          负整数：第一次被访问时，创建Servlet对象
     *          0或正整数：服务器启动时，创建Servlet对象（数字越小优先级越高）
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     *
     * 请求处理方法：每一次Servlet被访问时调用
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 服务终止方法：内存释放 或者 服务器关闭时，Servlet对象会被销毁，调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
