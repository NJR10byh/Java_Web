package com.migufun.web.Response;

import com.migufun.web.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NJR10byh
 * @date 2022/8/9 14:51:10
 * @description 响应字节数据
 */

@WebServlet("/resp4")
public class ResponseWriter2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、读取文件流
        //  FileInputStream fileInputStream = new FileInputStream("/Users/njr10byhtutu/Library/Mobile Documents/com~apple~CloudDocs/IMG_0888.jpeg");

        // 2、获取 response 输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        String checkcode = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);

        // 3、完成流的copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while ((len = fileInputStream.read(buff)) != -1) {
//            outputStream.write(buff, 0, len);
//        }

        // 使用工具类完成copy
//        IOUtils.copy(fileInputStream, outputStream);
//        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
