package com.qf;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.qf.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class XnsyxmApplication {

    public static void main(String[] args) {
        SpringApplication.run(XnsyxmApplication.class, args);
    }

}
