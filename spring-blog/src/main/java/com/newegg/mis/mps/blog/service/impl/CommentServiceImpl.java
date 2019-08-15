package com.newegg.mis.mps.blog.service.impl;

import com.newegg.mis.mps.blog.enums.ExceptionEnum;
import com.newegg.mis.mps.blog.exception.ControllerException;
import com.newegg.mis.mps.blog.mapper.CommentMapper;
import com.newegg.mis.mps.blog.pojo.Comment;
import com.newegg.mis.mps.blog.pojo.User;
import com.newegg.mis.mps.blog.service.CommentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/15.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentMapper commentMapper;

    @Override
    public ArrayList<Comment> getCommentListByArticle(Long articleId) {
        return commentMapper.getCommentListByArticle(articleId);
    }

    @Override
    public Integer insertComment(Comment comment) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null){
            throw new ControllerException(ExceptionEnum.NOT_LOGIN);
        }
        comment.setUserId(user.getUserId());
        return commentMapper.insertComment(comment);
    }
}
