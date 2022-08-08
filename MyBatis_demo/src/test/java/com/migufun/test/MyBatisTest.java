package com.migufun.test;

import com.migufun.mapper.GoodsInfoMapper;
import com.migufun.pojo.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NJR10byh
 * @date 2022/8/5 14:13:47
 * @description
 */

public class MyBatisTest {

    @Test
    public void TestSelectAll() throws IOException {
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

    @Test
    public void TestSelectById() throws IOException {
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

        // 4、执行方法
        int id = 1;
        Goods goods = mapper.selectById(id);
        System.out.println(goods);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestSelectByCondition() throws IOException {
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

        // 4、执行方法

        // 接受参数
        String brand = "HUAWEI";
        String goodsName = "Mate";

        // 处理参数
        brand = "%" + brand + '%';
        goodsName = "%" + goodsName + "%";

        Goods good = new Goods();
        good.setBrand(brand);
        good.setGoodsName(goodsName);

        Map map = new HashMap();
        map.put("brand", brand);
        map.put("goodsName", goodsName);

        List<Goods> goods = mapper.selectByCondition(goodsName, brand);

//        List<Goods> goods = mapper.selectByCondition(good);

//        List<Goods> goods = mapper.selectByCondition(map);
        System.out.println(goods);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestSelectByCondition_Pro() throws IOException {
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

        // 4、执行方法

        // 接受参数
        String brand = "HUAWEI";
        String goodsName = "Mate";

        // 处理参数
        brand = "%" + brand + '%';
        goodsName = "%" + goodsName + "%";

        Map map = new HashMap();
        map.put("brand", brand);
//        map.put("goodsName", goodsName);

        List<Goods> goods = mapper.selectByCondition_Pro(map);

        System.out.println(goods);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestSelectByCondition_Single() throws IOException {
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

        // 4、执行方法

        // 接受参数
        String brand = "HUAWEI";
        String goodsName = "Mate";

        // 处理参数
        brand = "%" + brand + '%';
        goodsName = "%" + goodsName + "%";

        Map map = new HashMap();
        map.put("brand", brand);
//        map.put("goodsName", goodsName);

        List<Goods> goods = mapper.selectByCondition_Single(map);

        System.out.println(goods);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestAdd() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession 对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 如果不想手动提交，openSession(true)
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、执行sql
        /**
         * selectList 会把结果自动封装成 List
         * selectOne 会把结果自动封装成 Object
         */
        // 3.1 获取 GoodsInfoMapper 接口的代理对象
        GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);

        // 4、执行方法
        // 接受参数
        String brand = "Apple";
        String goodsName = "Apple Watch SE";
        Double price = 2199.00;
        String description = "事事拿手，轻松入手。";

        Map map = new HashMap();
        map.put("goodsName", goodsName);
        map.put("brand", brand);
        map.put("price", price);
        map.put("description", description);
        mapper.addGoods(map);

        // 默认事务开启，需要手动提交
        sqlSession.commit();

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestAdd_getId() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession 对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 如果不想手动提交，openSession(true)
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、执行sql
        /**
         * selectList 会把结果自动封装成 List
         * selectOne 会把结果自动封装成 Object
         */
        // 3.1 获取 GoodsInfoMapper 接口的代理对象
        GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);

        // 4、执行方法
        // 接受参数
        String brand = "Apple";
        String goodsName = "Apple Watch Series 7";
        Double price = 2999.00;
        String description = "全屏先手";

        Goods good = new Goods();
        good.setGoodsName(goodsName);
        good.setBrand(brand);
        good.setPrice(price);
        good.setDescription(description);
        mapper.addGoods(good);

        Integer id = good.getId();
        System.out.println(id);

        // 默认事务开启，需要手动提交
        sqlSession.commit();


        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession 对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 如果不想手动提交，openSession(true)
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、执行sql
        /**
         * selectList 会把结果自动封装成 List
         * selectOne 会把结果自动封装成 Object
         */
        // 3.1 获取 GoodsInfoMapper 接口的代理对象
        GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);

        // 4、执行方法
        // 接受参数
        int id = 12;
        String description = "十足原创，请细品。";

        Goods good = new Goods();
        good.setId(id);
        good.setDescription(description);
        mapper.updateGoods(good);

        // 默认事务开启，需要手动提交
        sqlSession.commit();


        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestDeleteOne() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession 对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 如果不想手动提交，openSession(true)
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、执行sql
        /**
         * selectList 会把结果自动封装成 List
         * selectOne 会把结果自动封装成 Object
         */
        // 3.1 获取 GoodsInfoMapper 接口的代理对象
        GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);

        // 4、执行方法
        // 接受参数
        int id = 8;

        mapper.deleteOneGoods(id);

        // 默认事务开启，需要手动提交
        sqlSession.commit();


        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void TestDeleteMore() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession 对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 如果不想手动提交，openSession(true)
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、执行sql
        /**
         * selectList 会把结果自动封装成 List
         * selectOne 会把结果自动封装成 Object
         */
        // 3.1 获取 GoodsInfoMapper 接口的代理对象
        GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);

        // 4、执行方法
        // 接受参数
        int[] ids = {24, 25};

        mapper.deleteMoreGoods(ids);
        // 默认事务开启，需要手动提交
        sqlSession.commit();


        // 5、释放资源
        sqlSession.close();
    }
}
