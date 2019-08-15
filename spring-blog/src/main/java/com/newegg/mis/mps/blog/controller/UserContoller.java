package com.newegg.mis.mps.blog.controller;

import com.newegg.mis.mps.blog.enums.ExceptionEnum;
import com.newegg.mis.mps.blog.exception.ControllerException;
import com.newegg.mis.mps.blog.pojo.ResultBean;
import com.newegg.mis.mps.blog.pojo.User;
import com.newegg.mis.mps.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jt1n on 2019/8/9.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",origins = "http://localhost:4200")
public class UserContoller {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResultBean register(@RequestBody User user){
        Integer result = userService.register(user);
        if (result == 1){
            return ResultBean.success();
        }else {
            throw new ControllerException(ExceptionEnum.FAIL_CREATE);
        }
    }

    @PostMapping("/login")
    public ResultBean login(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken(user.getUserAccount(),user.getUserPassword());
        try{
            subject.login(token);
            return ResultBean.success();
        }catch (UnknownAccountException e){
            throw new ControllerException(ExceptionEnum.LOGIN_WRONG);
        }
    }

    @GetMapping("/logout")
    public ResultBean logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            subject.logout();
        }
        return ResultBean.success();
    }

    @GetMapping("/isLogin")
    public ResultBean isLogin(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            return ResultBean.success();
        }else {
            throw new ControllerException(ExceptionEnum.NOT_LOGIN);
        }
    }
}
