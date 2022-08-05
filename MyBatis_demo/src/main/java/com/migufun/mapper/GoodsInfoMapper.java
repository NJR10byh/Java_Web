package com.migufun.mapper;

import com.migufun.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author NJR10byh
 * @date 2022/8/4 17:41:53
 * @description
 */

public interface GoodsInfoMapper {
    // 查询所有
    List<Goods> selectAll();

    // 查看详情：根据id查询
    Goods selectById(int id);

    // 1、散装参数：如果方法中有多个参数，需要使用 @Param("SQL参数占位符名称")
    List<Goods> selectByCondition(@Param("goodsName") String goodsName, @Param("brand") String brand);

    // 2、实体类封装参数：SQL中的参数名 和 实体类属性名 对应
//    List<Goods> selectByCondition(Goods goods);

    // 3、map集合：SQL中的参数名 和 map集合的键名 对应
//    List<Goods> selectByCondition(Map map);

    // 多条件查询（动态SQL）
    List<Goods> selectByCondition_Pro(Map map);

    // 单条件查询（动态SQL）
    List<Goods> selectByCondition_Single(Map map);

    // 添加数据
    void addGoods(Map map);

}
