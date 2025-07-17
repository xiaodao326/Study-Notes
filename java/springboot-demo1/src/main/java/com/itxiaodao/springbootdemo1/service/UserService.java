package com.itxiaodao.springbootdemo1.service;

import com.itxiaodao.springbootdemo1.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User selectById(Integer id);
}
