package com.simple.service;

import com.github.pagehelper.PageHelper;
import com.simple.mapper.UserMapper;
import com.simple.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by songyigui on 2016/10/17.
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserInfo() {
        return userMapper.findUserInfo();
    }

    public List<User> listUser() {
        PageHelper.startPage(2, 2);
        return userMapper.listUser();
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertUser() {
        User user = new User(null, "123456", 12, "Shanghai", "小花");
        userMapper.insertUser(user);
//        int a = 1/0;
        userMapper.insertUser(user);
    }
}