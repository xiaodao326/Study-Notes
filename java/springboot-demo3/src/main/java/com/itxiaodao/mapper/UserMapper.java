package com.itxiaodao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Update("UPDATE user SET nickname=#{nickname}, email=#{email} WHERE id=#{id}")
    void updateUser(Long id, String nickname, String email);
}
