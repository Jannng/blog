package com.newegg.mis.mps.blog.service.impl;

import com.newegg.mis.mps.blog.mapper.UserMapper;
import com.newegg.mis.mps.blog.pojo.User;
import com.newegg.mis.mps.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jt1n on 2019/8/9.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer register(User user) {
        Integer result = userMapper.insertUser(user);
        return result;
    }

    @Override
    public User login(String username) {
        return userMapper.getUserByAccount(username);
    }
}
