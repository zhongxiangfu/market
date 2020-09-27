package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;


@Controller
public class DataSourceController {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/queryUserInfoList")
    @ResponseBody
    public List<User> queryUserInfoList() throws  Exception{
        //System.out.println(dataSource.getConnection());
        //System.out.println(dataSource.toString());
        System.out.println("45678");

        return iUserService.queryUserInfoList();
    }
    @RequestMapping("/insert")
    @ResponseBody
    public void insertUser(){
        User user = new User();
        user.setUserName("张三");
        user.setPassWord("123123");
        iUserService.insertUser(user);
    }

    @RequestMapping("/selectUserInfo")
    @ResponseBody
    public User selectUserInfo(){
        return iUserService.selectUserInfo();
    }
}
