package com.school.design.automobile_sales_mall.mapper;

import com.school.design.automobile_sales_mall.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByName(String userName);
}
