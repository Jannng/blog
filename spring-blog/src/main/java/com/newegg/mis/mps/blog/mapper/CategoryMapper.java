package com.newegg.mis.mps.blog.mapper;

import com.newegg.mis.mps.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * Created by jt1n on 2019/8/9.
 */
@Mapper
public interface CategoryMapper {
    ArrayList<Category> getAllCategory();
}
