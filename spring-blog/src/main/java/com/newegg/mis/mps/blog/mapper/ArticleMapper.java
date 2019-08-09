package com.newegg.mis.mps.blog.mapper;

import com.newegg.mis.mps.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/9.
 */
@Mapper
public interface ArticleMapper {
    Integer insertArticle(Article article);

    Integer updateArticle(Article article);

    Integer deleteArticle(@Param("ids") String ids);

    Article getArticleById(@Param("articleId") Long articleId);

    ArrayList<Article> getArticlesByUser(@Param("userId") Long userId);
}
