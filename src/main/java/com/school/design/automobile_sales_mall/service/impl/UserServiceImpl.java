package com.school.design.automobile_sales_mall.service.impl;

import com.school.design.automobile_sales_mall.entity.User;
import com.school.design.automobile_sales_mall.mapper.UserMapper;
import com.school.design.automobile_sales_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public Boolean addUser(User user) {
        return userMapper.addUser(user) == 1;
    }
}
