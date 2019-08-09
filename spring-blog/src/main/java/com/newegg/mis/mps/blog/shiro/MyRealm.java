package com.newegg.mis.mps.blog.shiro;

import com.newegg.mis.mps.blog.pojo.User;
import com.newegg.mis.mps.blog.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jt1n on 2019/8/9.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    UserService userService;


    /**
     * 用户权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用户登录
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        if (username == null){
            throw new AccountException("username is null");
        }
        User userDB = userService.login(username);
        if (userDB == null){
            throw new UnknownAccountException("can't find account [" + username +"]");
        }

        SimpleAuthenticationInfo info =
                new SimpleAuthenticationInfo(userDB,userDB.getUserPassword(),userDB.getUserAccount());
        return info;
    }
}
