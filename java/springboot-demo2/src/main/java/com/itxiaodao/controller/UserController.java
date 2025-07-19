package com.itxiaodao.controller;

import com.itxiaodao.pojo.User;
import com.itxiaodao.service.UserService;
import com.itxiaodao.util.JwtUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "注册成功";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        User user = userService.login(dto.getUsername(), dto.getPassword());
        return JwtUtil.generateToken(user.getId(), user.getUsername());
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @Data
    static class LoginDTO {
        private String username;
        private String password;
    }
}
