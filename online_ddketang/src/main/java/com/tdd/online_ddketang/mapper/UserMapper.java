package com.tdd.online_ddketang.mapper;

import com.tdd.online_ddketang.model.pojo.Episode;
import com.tdd.online_ddketang.model.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

     int save(User user);

     User findByPhone(@Param("phone") String phone);


     User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

     User findById(@Param("id") Integer id);

}
