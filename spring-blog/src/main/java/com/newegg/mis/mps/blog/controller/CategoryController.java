package com.newegg.mis.mps.blog.controller;

import com.newegg.mis.mps.blog.enums.ExceptionEnum;
import com.newegg.mis.mps.blog.exception.ControllerException;
import com.newegg.mis.mps.blog.pojo.Category;
import com.newegg.mis.mps.blog.pojo.ResultBean;
import com.newegg.mis.mps.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/14.
 */
@RestController
@RequestMapping("category")
@CrossOrigin(allowCredentials = "true")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("list")
    public ResultBean getAllCategory(){
        ArrayList<Category> categories = categoryService.getAllCategory();
        if (categories != null){
            return ResultBean.success(categories);
        }else {
            throw new ControllerException(ExceptionEnum.EMPTY);
        }
    }
}
