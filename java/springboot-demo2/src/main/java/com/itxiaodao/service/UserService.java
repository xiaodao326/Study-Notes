package com.itxiaodao.service;

import com.itxiaodao.mapper.UserMapper;
import com.itxiaodao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void register(User user) {
        User exist = userMapper.findByUsername(user.getUsername());
        if (exist != null) throw new RuntimeException("用户名已存在");
        userMapper.insert(user);
    }

    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("用户名或密码错误");
        }
        return user;
    }

    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
