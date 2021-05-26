package com.tdd.online_ddketang.exception;

import com.tdd.online_ddketang.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(DDexception.class);


    @ExceptionHandler(value = Exception.class)
    public JsonData myException(Exception e){
        if (e instanceof DDexception){
            DDexception dDexception = (DDexception) e;
            logger.error("自定义异常生效了...................................."+e.getMessage());
//            e.printStackTrace();
            return  JsonData.buildError(dDexception.getMsg(), dDexception.getCode());
        }else{
            logger.error("测试的....................................");
            logger.error(e.getMessage());
//            e.printStackTrace();

            return JsonData.buildError("全局异常 未知错误"+e.getMessage());
        }

    }

}
