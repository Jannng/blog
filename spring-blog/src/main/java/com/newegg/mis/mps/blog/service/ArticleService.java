package com.newegg.mis.mps.blog.service;

import com.newegg.mis.mps.blog.pojo.Article;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/13.
 */
public interface ArticleService {
    ArrayList<Article> getArticleList();

    Article getArticleById(Long id);

    Integer insertArticle(Article article);

    Integer view(Long articleId);

    ArrayList<Article> getArticleByUser();

    Integer update(Article article);

    Integer delete(String ids);
}
