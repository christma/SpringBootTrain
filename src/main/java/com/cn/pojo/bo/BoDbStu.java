package com.cn.pojo.bo;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.List;


@Data
@ToString
public class BoDbStu {
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private Integer sex;

    @Min(value = 1, message = "学生最小年年纪为1年级")
    @Max(value = 6, message = "学生最小年年纪为6年级")
    private Integer grade;

    @Range(min = 1, max = 18, message = "学生所在班级区间为1-18")
    private Integer classrome;
    @Size(min = 2, max = 5, message = "技能最少2个，最多5个")
    private List<String> skill;
    @Length(min = 3, max = 8, message = "英文名长度3-8")
    private String englishName;

    @Email(message = "邮箱格式不正确")
    private String email;
}