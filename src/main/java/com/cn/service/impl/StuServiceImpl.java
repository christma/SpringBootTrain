package com.cn.service.impl;

import com.cn.mapper.DbStuMapper;
import com.cn.pojo.DbStu;
import com.cn.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private DbStuMapper stuMapper;

    @Override
    public void saveStu(DbStu stu) {
        stuMapper.insert(stu);
    }
}
