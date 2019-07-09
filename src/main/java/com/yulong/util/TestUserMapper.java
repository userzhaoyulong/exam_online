package com.yulong.util;

import com.yulong.mapper.UserMapper;
import com.yulong.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: testSSM
 * @description:
 * @author: Dragon
 * @create: 2019-06-27 18:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml", "/spring-dao.xml"})
public class TestUserMapper {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void before(){
        sqlSession = sqlSessionFactory.openSession();
    }

   /* @Test
    public void testFindAll(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userL = userMapper.findAll();
        for (User user : userL) {
            System.out.println(user.getUsername());
        }
       System.out.println("执行了测试方法。。。");
    }*/

    @Test
    public void testLogin(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userL = userMapper.login("admin","123");
        System.out.println(userL);
    }

}
