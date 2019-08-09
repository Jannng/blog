package com.newegg.mis.mps.blog.exception;

import com.newegg.mis.mps.blog.enums.ExceptionEnum;

/**
 * Created by jt1n on 2019/8/9.
 */
public class ControllerException extends RuntimeException{
    private ExceptionEnum exception;

    public ControllerException(Throwable cause){super(cause);}

    public ControllerException(ExceptionEnum exception){
        this.exception = exception;
    }

    public ExceptionEnum getException() {
        return exception;
    }

    public void setException(ExceptionEnum exception) {
        this.exception = exception;
    }
}
