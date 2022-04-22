package com.cn.controller;


import com.cn.pojo.DbStu;
import com.cn.service.StuService;
import com.cn.utils.JsonResult;
import com.cn.utils.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("dbstu")
@Slf4j
public class DBStuController {

    @Autowired
    private StuService stuService;


    @PostMapping("create")
    public JsonResult createDBStu() {
        String id = UUID.randomUUID().toString();
        DbStu stu = new DbStu();
        stu.setId(id);
        stu.setName("大亮");
        stu.setSex(1);

        stuService.saveStu(stu);
        return JsonResult.ok();
    }

    @PostMapping("create2")
    public JsonResult createDBStu2(@RequestBody DbStu dbStu) {
        String id = UUID.randomUUID().toString();
        DbStu stu = new DbStu();
        BeanUtils.copyProperties(dbStu,stu);
        stu.setId(id);

        stuService.saveStu(stu);
        return JsonResult.ok();
    }


}
