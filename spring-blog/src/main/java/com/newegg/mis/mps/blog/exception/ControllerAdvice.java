package com.newegg.mis.mps.blog.exception;

import com.newegg.mis.mps.blog.pojo.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jt1n on 2019/8/9.
 */
@org.springframework.web.bind.annotation.ControllerAdvice
@ResponseBody
public class ControllerAdvice {
    @ExceptionHandler(value = ControllerException.class)
    public ResultBean controllerExceptionHandler(ControllerException e) {
        return ResultBean.error(e.getException().getCode(), e.getException().getMsg());
    }
}
