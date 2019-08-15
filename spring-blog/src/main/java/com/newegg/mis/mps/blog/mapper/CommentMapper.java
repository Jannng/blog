package com.newegg.mis.mps.blog.mapper;

import com.newegg.mis.mps.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/14.
 */
@Mapper
public interface CommentMapper {
    Integer insertComment(Comment comment);

    ArrayList<Comment> getCommentListByArticle(@Param("articleId") Long articleId);
}
