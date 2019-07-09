package com.yulong.service.Impl;

import com.yulong.mapper.UserMapper;
import com.yulong.pojo.Grade;
import com.yulong.pojo.User;
import com.yulong.service.UserService;
import com.yulong.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.TrustAnchor;
import java.util.List;

/**
 * @program: testSSM
 * @description: 用户Service实现类
 * @author: Dragon
 * @create: 2019-06-27 17:25
 */
@Service
public class UserServiceImpl implements UserService{
    /**
     * 注入UserMapper接口
     */
    @Autowired
    private UserMapper userMapper;

    //用户登录
    @Override
    public User login(String username, String userpwd) {
        return userMapper.login(username,userpwd);
    }

    @Override
    public boolean checkUserId(String userid) {
        User user = userMapper.checkUserId(userid);
        boolean flag = false;
        if (user != null)
            flag = true;
        System.out.println("userid" + userid);
        return flag;
    }

    @Override
    public void registUser(User user) {
        user.setUsertype(0);
        user.setUserstate(0);
        user.setRemark("暂无！");
        //对密码进行加密
        String pwdByMD5 = MD5Util.getPwdByMD5(user.getUserpwd());
        user.setUserpwd(pwdByMD5);
        userMapper.registUser(user);
    }

    @Override
    public List<Grade> getGrade() {
        return userMapper.getGrade();
    }
}
