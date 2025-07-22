package com.itxiaodao.pojo;

import com.itxiaodao.anno.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Article {
    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String coverImg;

    @NotNull
    private Long categoryId;

    @State
    private String state;
}
