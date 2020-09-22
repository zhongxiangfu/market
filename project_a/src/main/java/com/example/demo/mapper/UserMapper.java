package com.example.demo.mapper;

import com.example.demo.domain.User;

import java.util.List;

public interface UserMapper {

    public void insert(User user);

    public List<User> queryUserInfoList();

    public User selectUserInfo();
}
