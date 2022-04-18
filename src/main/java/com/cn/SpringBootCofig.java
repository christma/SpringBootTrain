package com.cn;

import com.cn.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootCofig {
    @Bean
    public Stu stu() {
        return new Stu("jack", 19);
    }
}
