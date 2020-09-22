package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoTest {
    Integer num = 0;
    @RequestMapping("/test")
    @ResponseBody
    public String test(String str){
        String s = "11111";
        return s;
    }
}
