package com.migufun.web.ajax;

import com.alibaba.fastjson.JSON;
import com.migufun.web.mapper.userLoginMapper;
import com.migufun.web.pojo.userInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author NJR10byh
 * @date 2022/8/11 15:23:01
 * @description
 */

@WebServlet("/ajaxServlet")
public class ajaxDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        System.out.println("username: " + username);
//        System.out.println("password: " + password);

        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        userInfo user = JSON.parseObject(params, userInfo.class);
        System.out.println(user);

        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (this.searchUser(user.getUsername(), user.getPassword())) {
            resp.setStatus(200);
            writer.write("ok");
        } else {
            resp.setStatus(200);
            writer.write("error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    public boolean searchUser(String username, String password) throws IOException {
        System.out.println(username);
        System.out.println(password);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession 对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、执行sql
        /**
         * selectList 会把结果自动封装成 List
         * selectOne 会把结果自动封装成 Object
         */

        // 3.1 获取 GoodsInfoMapper 接口的代理对象
        userLoginMapper mapper = sqlSession.getMapper(userLoginMapper.class);

        // 4、执行方法
        userInfo user = mapper.selectUser_Axios(username, password);
        System.out.println(user);

        // 5、释放资源
        sqlSession.close();
        if (user != null) {
            return true;
        } else {
            return false;
        }

    }
}
