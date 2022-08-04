package com.migufun;

import com.migufun.mapper.GoodsInfoMapper;
import com.migufun.pojo.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author NJR10byh
 * @date 2022/8/4 18:15:30
 * @description
 */

public class Mybatis_mapper {
    public static void main(String[] args) throws IOException {
        // 1、加载 Mybatis 核心配置文件，获取 SqlSessionFactory
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
        // List<Goods> goods = sqlSession.selectList("goods_info.selectAllGoods");

        // 3.1 获取 GoodsInfoMapper 接口的代理对象
        GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
        List<Goods> goods = mapper.selectAll();
        System.out.println(goods);

        // 4、释放资源
        sqlSession.close();
    }
}
