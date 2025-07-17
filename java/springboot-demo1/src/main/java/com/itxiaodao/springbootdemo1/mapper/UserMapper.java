package com.itxiaodao.springbootdemo1.mapper;

import com.itxiaodao.springbootdemo1.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
//    @Select("select * from user where id = #{id};")
    User getUserById(Integer id);
}
