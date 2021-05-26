package com.tdd.online_ddketang.config;

import com.tdd.online_ddketang.interceptor.CorsInterceptor;
import com.tdd.online_ddketang.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器器配置
 *
 * 不用权限可以访问url  /api/v1/pub/
 * 要登录可以访问url  /api/v1/pri/
 */

@Configuration
public class MvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //配置跨域拦截,所有请求
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        //配置的登录拦截
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")  //拦截路径
                .excludePathPatterns("/api/v1/pri/user/register","/api/v1/pri/user/login");//拦截放行路径
//        WebMvcConfigurer.super.addInterceptors(registry);

    }

    @Bean
    LoginInterceptor loginInterceptor(){
        return  new LoginInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor(){
        return  new CorsInterceptor();
    }
}
