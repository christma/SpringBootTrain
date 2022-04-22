package com.cn.pojo.bo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;


@Data
@ToString
public class BoDbStu {
    private String id;
    private String name;
    private Integer sex;

}