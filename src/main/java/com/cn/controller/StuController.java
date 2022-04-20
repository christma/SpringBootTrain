package com.cn.controller;


import com.cn.utils.JsonResult;
import com.cn.utils.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("stu")
@Slf4j
public class StuController {

    @GetMapping("{stuId}/get")
    public String getStu(@PathVariable("stuId") String stuId, @RequestParam String name, @RequestParam Integer age) {
        log.info(stuId);
        log.info(name);
        log.info(age.toString());
        return "查询STU";
    }

    @PostMapping("create")
    public JsonResult createStu(@RequestBody Map<String,Object> body
            , @RequestHeader("token") String token
            , @CookieValue("clientId") String clientId
    , HttpServletRequest request) {

        log.info(body.toString());
        log.info(token);
        log.info(clientId);


        String tokenHeader = request.getHeader("token");

        log.info(tokenHeader);

        return JsonResult.ok(body);
    }


    @Autowired
    private MyAsyncTask myAsyncTask;
    @PutMapping("update")
    public String updateStu() {
        myAsyncTask.publishMsg();
        return "更新STU";
    }

    @DeleteMapping("delete")
    public String deleteStu() {
        return "删除STU";
    }


}
