package com.newegg.mis.mps.blog.mapper;

import com.newegg.mis.mps.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jt1n on 2019/8/9.
 */
@Mapper
public interface UserMapper {
    Integer insertUser(User user);

    User getUserByAccount(@Param("userAccount") String userAccount);
}
