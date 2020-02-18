package com.school.design.automobile_sales_mall.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;

    private String userName;

    private String password;

    private String phone;

    private String email;
//
//    private Integer age;
//
//    private Integer role;
}
