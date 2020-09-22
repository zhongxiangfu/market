package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface IUserService {

    public void insertUser(User user);

    public List<User> queryUserInfoList();

    public User selectUserInfo();
}
