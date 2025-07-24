package com.itxiaodao.controller;

import com.itxiaodao.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    // 模拟登录
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 只要输入任意 username/password 就返回 token
        long expire = 60 * 60 * 1000; // 1小时
        String token = JwtUtil.generateToken(username, expire);

        // 保存到 Redis
        redisTemplate.opsForValue().set(token, username, expire, TimeUnit.MILLISECONDS);

        return token;
    }

    // 模拟注销
    @PostMapping("/logout")
    public String logout(@RequestHeader("token") String token) {
        redisTemplate.delete(token);
        return "Logout success!";
    }
}
