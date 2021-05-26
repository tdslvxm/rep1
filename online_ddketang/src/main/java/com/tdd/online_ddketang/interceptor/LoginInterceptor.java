package com.tdd.online_ddketang.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.online_ddketang.utils.JWTUtils;
import com.tdd.online_ddketang.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String token = request.getHeader("token");
            if (token==null){
                token = request.getParameter("token");
            }
            if (StringUtils.hasLength(token)){//token有值
                Claims claims = JWTUtils.checkJWT(token);
                if (claims==null){
                    sendJsonMessage(response, JsonData.buildError("登录过期,请重新登录", -1));
                    return  false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("user_id", id);
                request.setAttribute("name", name);
                return true;//放行

            }else{
                sendJsonMessage(response, JsonData.buildError("token不存在", -1));
                return  false;
            }
        }catch (Exception e){
            sendJsonMessage(response, JsonData.buildError("异常,请检查代码", -1));
            return  false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public static void sendJsonMessage(HttpServletResponse response,Object obj){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json");//响应类型为json
            response.setCharacterEncoding("UTF-8");//解决中文乱码问题

            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
