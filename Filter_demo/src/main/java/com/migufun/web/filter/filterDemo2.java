package com.migufun.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author NJR10byh
 * @date 2022/8/11 14:20:19
 * @description
 */

@WebFilter("/*")
public class filterDemo2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1、放行前对 request 数据进行处理
        System.out.println("2、Filter......");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        // 2、放行后对 response 数据进行处理
        System.out.println("4、Filter......");
    }

    @Override
    public void destroy() {

    }
}
