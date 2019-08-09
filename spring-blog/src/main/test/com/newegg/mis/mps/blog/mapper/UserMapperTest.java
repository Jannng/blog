package com.newegg.mis.mps.blog.mapper;

import com.newegg.mis.mps.blog.BlogMain;
import com.newegg.mis.mps.blog.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by jt1n on 2019/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogMain.class)
@WebAppConfiguration
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUserAccount("tang");
        user.setUserPassword("123");
        Integer integer = userMapper.insertUser(user);
        System.out.println(integer);
    }

    @Test
    public void getUserByAccount() throws Exception {
        User tang = userMapper.getUserByAccount("tang");
        System.out.println(tang);
    }
}