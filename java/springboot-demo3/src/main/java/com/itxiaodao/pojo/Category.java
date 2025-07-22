package com.itxiaodao.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Category {

    @NotBlank(groups = Add.class)
    private String name;

    @NotBlank(groups = Add.class)
    private String alias;

    public interface Add {}
}
