package com.yulong.service.Impl;

import com.yulong.mapper.InfoMapper;
import com.yulong.pojo.User;
import com.yulong.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: exam_online
 * @description: 用户信息管理模块
 * @author: Dragon
 * @create: 2019-07-08 20:31
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<User> getAllNotVerify() {
        return infoMapper.getAllNotVerify();
    }
}
