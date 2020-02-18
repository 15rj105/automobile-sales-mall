package com.school.design.automobile_sales_mall.service;

import com.school.design.automobile_sales_mall.entity.User;

public interface UserService {
    User getUserByName(String userName);

    Boolean addUser(User user);
}
