package com.itxiaodao.springbootdemo1.controller;

import com.itxiaodao.springbootdemo1.mapper.UserMapper;
import com.itxiaodao.springbootdemo1.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
