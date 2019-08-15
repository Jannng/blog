package com.newegg.mis.mps.blog.service.impl;

import com.newegg.mis.mps.blog.mapper.CategoryMapper;
import com.newegg.mis.mps.blog.pojo.Category;
import com.newegg.mis.mps.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/14.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ArrayList<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }
}
