package com.springboot.userserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.userserver.mapper") // 你的 Mapper 包路径
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }

}
