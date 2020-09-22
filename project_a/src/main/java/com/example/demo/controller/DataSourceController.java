package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;


@Controller
public class DataSourceController {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/dataSource")
    @ResponseBody
    public String dataSource() throws  Exception{
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource.toString());
        return "connect datasource success";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public void insertUser(){
        User user = new User();
        user.setUserName("张三");
        user.setPassWord("123123");
        iUserService.insertUser(user);
    }
}
