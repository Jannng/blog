package com.newegg.mis.mps.blog.service;

import com.newegg.mis.mps.blog.pojo.User;

/**
 * Created by jt1n on 2019/8/9.
 */
public interface UserService {
    Integer register(User user);

    User login(String username);
}
