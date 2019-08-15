package com.newegg.mis.mps.blog.service;

import com.newegg.mis.mps.blog.pojo.Comment;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/14.
 */
public interface CommentService {
    ArrayList<Comment> getCommentListByArticle(Long articleId);

    Integer insertComment(Comment comment);
}
