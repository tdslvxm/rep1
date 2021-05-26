package com.tdd.online_ddketang.controller;


import com.tdd.online_ddketang.model.pojo.User;
import com.tdd.online_ddketang.model.request.LoginRequest;
import com.tdd.online_ddketang.service.UserService;
import com.tdd.online_ddketang.utils.JWTUtils;
import com.tdd.online_ddketang.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public JsonData register(@RequestBody Map<String,String> userInfo){
        return userService.save(userInfo)>0 ? JsonData.buildSuccess("创建成功!"):JsonData.buildError("创建用户失败");

    }

    @PostMapping("/login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        //测试部分 测试jwt校验token是否正常
        if (token!=null){
            Claims claims = JWTUtils.checkJWT(token);
            System.out.println(claims.get("id"));
            System.out.println(claims.get("name"));
            System.out.println(claims.get("head_img"));
        }
        return token==null?JsonData.buildError("登陆失败,请检查账户密码"):JsonData.buildSuccess(token );

    }


    @GetMapping("find_user_by_token")
    public JsonData findUserByToken(HttpServletRequest request){
        Integer user_id = (Integer) request.getAttribute("user_id");
        String  name = (String )request.getAttribute("name");
        if (user_id==null){
            return  JsonData.buildError("用户不存在");
        }
        User user = userService.findById(user_id);
        return  JsonData.buildSuccess(user);

    }
}
