package com.itxiaodao.springbootdemo1.service.impl;

import com.itxiaodao.springbootdemo1.mapper.UserMapper;
import com.itxiaodao.springbootdemo1.pojo.User;
import com.itxiaodao.springbootdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectById(Integer id) {
        return userMapper.getUserById(id);
    }
}
