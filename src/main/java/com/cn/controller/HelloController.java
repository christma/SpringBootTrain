package com.cn.controller;


import com.cn.pojo.MyConfig;
import com.cn.pojo.Stu;
import com.cn.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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

    @Value("${app.xxx.yyy.zzz}")
    private String xyz;

    @GetMapping("getYmlConfig")
    public Object getYmlConfig(){
        return xyz;
    }



    @GetMapping("getStudent")
    public Object getStudent(){
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(10);
        log.info(student.toString());
        log.warn(student.toString());
        log.error(student.toString());

        return student;
    }

}
