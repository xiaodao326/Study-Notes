package com.itxiaodao.controller;

import com.itxiaodao.pojo.User;
import com.itxiaodao.result.Result;
import com.itxiaodao.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/update")
    public Result updateUser(@Valid @RequestBody User dto) {
        userService.updateUser(dto);
        return Result.success();
    }

    @PostMapping("/upload-avatar")
    public Result uploadAvatar(@RequestParam("file") MultipartFile file) {
        String url = userService.uploadAvatar(file);
        return Result.success(url);
    }
}
