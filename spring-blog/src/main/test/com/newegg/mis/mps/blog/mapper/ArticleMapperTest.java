package com.newegg.mis.mps.blog.mapper;

import com.newegg.mis.mps.blog.BlogMain;
import com.newegg.mis.mps.blog.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jt1n on 2019/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogMain.class)
@WebAppConfiguration
public class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void getArticleById() throws Exception {

    }

    @Test
    public void getArticleList() throws Exception {
        ArrayList<Article> articleList = articleMapper.getArticleList();
        articleList.forEach(System.out::println);
    }
}