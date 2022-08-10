package com.migufun.mapper;

import com.migufun.pojo.userInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author NJR10byh
 * @date 2022/8/10 11:04:16
 * @description
 */

public interface userLoginMapper {
    userInfo selectUser(@Param("username") String username, @Param("password") String password);
}
