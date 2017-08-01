package com.simple.mapper;

import com.simple.model.User;

import java.util.List;

/**
 * Created by songyigui on 2016/10/17.
 */
public interface UserMapper {
    public User findUserInfo();

    List<User> listUser();

    void insertUser(User user);
}
