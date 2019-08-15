package com.newegg.mis.mps.blog.controller;

import com.newegg.mis.mps.blog.enums.ExceptionEnum;
import com.newegg.mis.mps.blog.exception.ControllerException;
import com.newegg.mis.mps.blog.pojo.Comment;
import com.newegg.mis.mps.blog.pojo.ResultBean;
import com.newegg.mis.mps.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/15.
 */
@RestController
@RequestMapping("comment")
@CrossOrigin(allowCredentials = "true")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/list/{id}")
    public ResultBean getList(@PathVariable("id") Long articleId){
        ArrayList<Comment> comments = commentService.getCommentListByArticle(articleId);
        if (comments == null){
            throw new ControllerException(ExceptionEnum.EMPTY);
        }else {
            return ResultBean.success(comments);
        }
    }

    @PostMapping("/publish")
    public ResultBean publishComment(@RequestBody Comment comment){
        Integer result;
        try{
            result = commentService.insertComment(comment);
        }catch (ControllerException e){
            throw e;
        }
        if (result > 0 ){
            return ResultBean.success();
        }else {
            throw new ControllerException(ExceptionEnum.FAIL_CREATE);
        }
    }
}
