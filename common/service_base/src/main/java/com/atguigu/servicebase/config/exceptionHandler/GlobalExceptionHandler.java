package com.atguigu.servicebase.config.exceptionHandler;

import com.atguigu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R erro(Exception e){
        e.printStackTrace();
        return R.erro().message("执行全局异常");
    }

    //自定义异常处理
    @ExceptionHandler(AutoGuliException.class)
    @ResponseBody
    public R erro(AutoGuliException e){
        e.printStackTrace();
        log.error(e.getMsg());
        return R.erro().code(e.getCode()).message(e.getMsg());
    }

}
