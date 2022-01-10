package com.atguigu.servicebase.config.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoGuliException extends RuntimeException{
    private Integer code;

    private String msg;
}
