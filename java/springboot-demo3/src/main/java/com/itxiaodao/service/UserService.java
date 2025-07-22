package com.itxiaodao.service;

import com.itxiaodao.mapper.UserMapper;
import com.itxiaodao.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public void updateUser(User dto) {
        Long userId = 1L; // 模拟 ThreadLocal 或 JWT 拦截器获取
        userMapper.updateUser(userId, dto.getNickname(), dto.getEmail());
    }

    public String uploadAvatar(MultipartFile file) {
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String path = "D:/upload/" + filename;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "/upload/" + filename;
    }
}
