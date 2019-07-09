package com.yulong.mapper;

import com.yulong.pojo.Grade;
import com.yulong.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Dragon
 * @Description 描述用户的Mapper接口
 * @Date 17:07 2019/6/27
 * @Param
 * @return
 **/
@Repository
public interface UserMapper {

        User login(@Param("userid") String userid, @Param("userpwd") String userpwd);

        User checkUserId(String userid);

        void registUser(User user);

        List<Grade> getGrade();
}
