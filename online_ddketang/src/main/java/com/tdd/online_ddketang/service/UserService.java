package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.model.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    int save(Map<String,String > userInfo);

    /**
     * 通过phone查询用户---可以判断是否注册
     * @param phone
     * @return
     */
    User findByPhone(@Param("phone") String phone);


    /**
     * 通过phone和pwd查询用户
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 通过id
     * @param id
     * @return
     */
    User findById(@Param("id") Integer id);
}
