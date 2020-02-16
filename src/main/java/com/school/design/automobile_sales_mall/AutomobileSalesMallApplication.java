package com.school.design.automobile_sales_mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.school.design.automobile_sales_mall.*")
@MapperScan("com.school.design.automobile_sales_mall.mapper")
public class AutomobileSalesMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomobileSalesMallApplication.class, args);
    }

}
