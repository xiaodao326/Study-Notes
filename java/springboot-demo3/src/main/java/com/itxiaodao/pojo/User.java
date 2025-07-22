package com.itxiaodao.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {
    @NotBlank
    private String nickname;

    @Email
    private String email;
}

