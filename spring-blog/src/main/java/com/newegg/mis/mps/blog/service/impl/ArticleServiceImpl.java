package com.newegg.mis.mps.blog.service.impl;

import com.newegg.mis.mps.blog.mapper.ArticleMapper;
import com.newegg.mis.mps.blog.pojo.Article;
import com.newegg.mis.mps.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/13.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public ArrayList<Article> getArticleList() {
        return articleMapper.getArticleList();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleMapper.getArticleById(id);
    }
}
