package com.cn.controller;


import com.cn.pojo.DbStu;
import com.cn.pojo.bo.BoDbStu;
import com.cn.service.StuService;
import com.cn.service.impl.StuServiceImpl;
import com.cn.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("dbstu")
@Slf4j
public class DBStuController {

    @Autowired
    private StuService stuService;

    @Autowired
    private StuServiceImpl stuServiceImpl;


    @GetMapping("get")
    public JsonResult queryById(String stuId) {

        DbStu dbStu = stuService.queryById(stuId);

        List<DbStu> stuList = stuService.queryByCondition("大亮", 1);


        return JsonResult.ok(stuList);
    }


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
    public JsonResult createDBStu2(@Valid @RequestBody BoDbStu dbStu,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return JsonResult.errorMap(getErrors(result));
        }
        String id = UUID.randomUUID().toString();
        DbStu stu = new DbStu();
        BeanUtils.copyProperties(dbStu, stu);
        stu.setId(id);

        stuService.saveStu(stu);
        return JsonResult.ok();
    }

    private Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error: errorList) {
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }

        return map;

    }

    @GetMapping("update")
    public JsonResult updateStu() {
        DbStu dbStu = new DbStu();
        dbStu.setId("90be837a-9b09-4bdb-8d44-68b18fd224f5");
        dbStu.setName("被更新的大亮");
        dbStu.setSex(2);

        stuServiceImpl.updateByKey(dbStu);
        return JsonResult.ok();
    }


    @GetMapping("del")
    public JsonResult deleteStu(String id){

        stuServiceImpl.deleteByKey(id);
        return JsonResult.ok();

    }

}
