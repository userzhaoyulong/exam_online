package com.yulong.mapper;

import com.yulong.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoMapper {

    List<User> getAllNotVerify();

}
