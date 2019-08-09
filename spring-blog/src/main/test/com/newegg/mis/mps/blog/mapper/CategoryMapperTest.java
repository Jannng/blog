package com.newegg.mis.mps.blog.mapper;

import com.newegg.mis.mps.blog.BlogMain;
import com.newegg.mis.mps.blog.pojo.Category;
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
public class CategoryMapperTest {
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void getAllCategory() throws Exception {
        ArrayList<Category> allCategory = categoryMapper.getAllCategory();
        allCategory.forEach(System.out::println);
    }
}