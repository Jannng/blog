package com.newegg.mis.mps.blog.service.impl;

import com.newegg.mis.mps.blog.enums.ExceptionEnum;
import com.newegg.mis.mps.blog.exception.ControllerException;
import com.newegg.mis.mps.blog.mapper.ArticleMapper;
import com.newegg.mis.mps.blog.pojo.Article;
import com.newegg.mis.mps.blog.pojo.User;
import com.newegg.mis.mps.blog.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

    @Override
    public Integer insertArticle(Article article) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null){
            throw new ControllerException(ExceptionEnum.NOT_LOGIN);
        }
        article.setUserId(user.getUserId());
        article.setArticleViews(0L);
        article.setArticleCommentCount(0L);
        return articleMapper.insertArticle(article);
    }

    @Override
    public Integer view(Long articleId) {
        return articleMapper.view(articleId);
    }
}
