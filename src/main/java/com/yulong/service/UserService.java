package com.yulong.service;

import com.yulong.pojo.Grade;
import com.yulong.pojo.User;

import java.util.List;

/**
 * @Author Dragon
 * @Description 用户service层
 * @Date 17:24 2019/6/27
 * @Param
 * @return
 **/
public interface UserService {

        User login(String username,String userpwd);

        boolean checkUserId(String userid);

        void registUser(User user);

        List<Grade> getGrade();
}
