package com.tdd.online_ddketang.controller;


import com.tdd.online_ddketang.exception.DDexception;
import com.tdd.online_ddketang.model.pojo.User;
import com.tdd.online_ddketang.model.request.LoginRequest;
import com.tdd.online_ddketang.model.request.VideoOrderRequest;
import com.tdd.online_ddketang.service.UserService;
import com.tdd.online_ddketang.service.VideoOrderService;
import com.tdd.online_ddketang.utils.JWTUtils;
import com.tdd.online_ddketang.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 下单接口 需要用户登录 所以接口规范用pri
 */
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    VideoOrderService videoOrderService;


    @PostMapping("/save")
    public JsonData save(@RequestBody VideoOrderRequest videoOrderRequest,HttpServletRequest request) throws DDexception {
        int userId = (Integer) request.getAttribute("user_id");
        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());
        return  rows==0?JsonData.buildError("下单失败!"):JsonData.buildSuccess(rows);
    }

}
