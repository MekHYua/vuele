package com.mekhyua.vuele;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mekhyua.vuele.dao")
public class VueleApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueleApplication.class, args);
    }

}
