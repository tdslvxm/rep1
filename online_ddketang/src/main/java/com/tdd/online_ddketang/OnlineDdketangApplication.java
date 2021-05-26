package com.tdd.online_ddketang;

import com.tdd.online_ddketang.mapper.VideoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启事务
@MapperScan("com.tdd.online_ddketang.mapper") //扫描mapper
public class OnlineDdketangApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineDdketangApplication.class, args);
    }

}
