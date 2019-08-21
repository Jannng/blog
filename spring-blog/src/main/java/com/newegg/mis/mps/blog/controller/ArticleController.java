package com.newegg.mis.mps.blog.controller;

import com.newegg.mis.mps.blog.enums.ExceptionEnum;
import com.newegg.mis.mps.blog.exception.ControllerException;
import com.newegg.mis.mps.blog.pojo.Article;
import com.newegg.mis.mps.blog.pojo.ResultBean;
import com.newegg.mis.mps.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jt1n on 2019/8/13.
 */
@RestController
@RequestMapping("article")
@CrossOrigin(allowCredentials = "true")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/getList")
    public ResultBean getArticleList() {
        ArrayList<Article> articleList = articleService.getArticleList();
        if (articleList != null) {
            return ResultBean.success(articleList);
        } else {
            throw new ControllerException(ExceptionEnum.EMPTY);
        }
    }

    @GetMapping("/get/{id}")
    public ResultBean getArticle(@PathVariable("id") Long id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return ResultBean.success(Collections.singletonList(article));
        } else {
            throw new ControllerException(ExceptionEnum.EMPTY);
        }
    }

    @PostMapping("/publish")
    public ResultBean<Article> publish(@RequestBody Article article) {
        Integer result;
        try {
            result = articleService.insertArticle(article);
        } catch (ControllerException e) {
            throw e;
        }
        if (result > 0) {
            return ResultBean.success();
        } else {
            throw new ControllerException(ExceptionEnum.FAIL_CREATE);
        }
    }

    @GetMapping("/view/{id}")
    public ResultBean<Article> view(@PathVariable("id") Long articleId) {
        Integer result = articleService.view(articleId);
        if (result > 0) {
            return ResultBean.success();
        } else {
            throw new ControllerException(ExceptionEnum.EMPTY);
        }
    }

    @GetMapping("/myArticle")
    public ResultBean<Article> getArticleByUser() {
        ArrayList<Article> articles;
        try {
            articles = articleService.getArticleByUser();
            if (articles != null) {
                return ResultBean.success(articles);
            } else {
                throw new ControllerException(ExceptionEnum.EMPTY);
            }
        } catch (ControllerException e) {
            throw e;
        }
    }

    @PostMapping("/update")
    public ResultBean<Integer> update(@RequestBody Article article) {
        Integer res;
        try {
            res = articleService.update(article);
            if (res >= 1) {
                return ResultBean.success();
            } else {
                throw new ControllerException(ExceptionEnum.OPERATION_FAILURE);
            }
        } catch (ControllerException c) {
            throw c;
        }
    }

    @GetMapping("/delete/{ids}")
    public ResultBean<Integer> delete(@PathVariable("ids") String ids) {
        Integer res;
        try {
            res = articleService.delete(ids);
            if (res > 0) {
                return ResultBean.success();
            } else {
                throw new ControllerException(ExceptionEnum.OPERATION_FAILURE);
            }
        } catch (ControllerException c) {
            throw c;
        }
    }
}
