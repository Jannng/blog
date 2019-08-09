package com.newegg.mis.mps.blog.pojo;

import java.util.Collection;

/**
 * Created by jt1n on 2019/8/9.
 */
public class ResultBean<T> {
    private int code;

    private String msg;

    private Collection<T> data;

    public ResultBean() {
    }

    public static ResultBean error(int code, String msg){
        ResultBean result = new ResultBean<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static ResultBean success(){
        ResultBean result = new ResultBean();
        result.setCode(0);
        result.setMsg("success");
        return result;
    }

    public static <V> ResultBean<V> success(Collection<V> data){
        ResultBean result = new ResultBean();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

}
