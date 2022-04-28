package com.cn.service;

import com.cn.pojo.DbStu;

import java.util.List;

public interface StuService {
    // 新增stu
    void saveStu(DbStu stu);

    // 查询

    DbStu queryById(String Id);

    // 条件查询

    List<DbStu> queryByCondition(String name, Integer sex);

    // 更新
    void updateByKey(DbStu stu);


    // 删除
    void deleteByKey(String Id);

}
