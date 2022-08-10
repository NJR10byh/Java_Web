package com.migufun;

import com.migufun.mapper.userLoginMapper;
import com.migufun.pojo.userInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author NJR10byh
 * @date 2022/8/10 09:59:50
 * @description
 */

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (this.searchUser(username, password)) {
            resp.setStatus(200);
            writer.write("<h1>登录成功！</h1>");
        } else {
            resp.setStatus(404);
            writer.write("<h1>登录失败！</h1>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    public boolean searchUser(String username, String password) throws IOException {
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
        userInfo user = mapper.selectUser(username, password);
        System.out.println(user);

        sqlSession.close();
        if (user != null) {
            return true;
        } else {
            return false;
        }

        // 5、释放资源

    }
}
