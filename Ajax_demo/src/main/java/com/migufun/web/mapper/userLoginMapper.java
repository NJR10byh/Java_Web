package com.migufun.web.mapper;

import com.migufun.web.pojo.userInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author NJR10byh
 * @date 2022/8/11 15:52:38
 * @description
 */

public interface userLoginMapper {
    userInfo selectUser_Axios(@Param("username") String username, @Param("password") String password);
}
