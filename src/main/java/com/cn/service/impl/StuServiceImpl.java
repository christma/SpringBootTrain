package com.cn.service.impl;

import com.cn.mapper.DbStuMapper;
import com.cn.pojo.DbStu;
import com.cn.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private DbStuMapper stuMapper;

    @Override
    public void saveStu(DbStu stu) {
        stuMapper.insert(stu);
    }

    @Override
    public DbStu queryById(String Id) {
        DbStu dbStu = stuMapper.selectByPrimaryKey(Id);
        return dbStu;
    }

    @Override
    public List<DbStu> queryByCondition(String name, Integer sex) {

        Example example = new Example(DbStu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        criteria.andEqualTo("sex", sex);

        List<DbStu> dbStuList = stuMapper.selectByExample(example);

        return dbStuList;
    }

    @Override
    public void updateByKey(DbStu stu) {
        stuMapper.updateByPrimaryKey(stu);
    }

    @Override
    public void deleteByKey(String Id) {
        stuMapper.deleteByPrimaryKey(Id);
    }


}
