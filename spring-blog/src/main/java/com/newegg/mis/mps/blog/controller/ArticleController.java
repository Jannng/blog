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
@CrossOrigin
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/getList")
    public ResultBean getArticleList(){
        ArrayList<Article> articleList = articleService.getArticleList();
        if (articleList != null){
            return ResultBean.success(articleList);
        }else {
            throw new ControllerException(ExceptionEnum.EMPTY);
        }
    }

    @GetMapping("/get/{id}")
    public ResultBean getArticle(@PathVariable("id") Long id){
        Article article = articleService.getArticleById(id);
        if (article != null){
            return ResultBean.success(Collections.singletonList(article));
        }else {
            throw new ControllerException(ExceptionEnum.EMPTY);
        }
    }
}
