package com.cn.controller;


import com.cn.pojo.MyConfig;
import com.cn.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "Hello NiHao ~~";
    }

    @Autowired
    private Stu stu;

    @GetMapping("getStu")
    public Object getStu(){
        return stu;
    }


    @Autowired
    private MyConfig myConfig;

    @GetMapping("getMyConfig")
    public Object getMyConfig(){
        return myConfig;
    }
}
