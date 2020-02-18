package com.school.design.automobile_sales_mall.mapper;

import com.school.design.automobile_sales_mall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserByName(String userName);

    int addUser(@Param("user") User user);
}
