package com.newegg.mis.mps.blog.service;

import com.newegg.mis.mps.blog.pojo.Article;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/13.
 */
public interface ArticleService {
    ArrayList<Article> getArticleList();

    Article getArticleById(Long id);
}
