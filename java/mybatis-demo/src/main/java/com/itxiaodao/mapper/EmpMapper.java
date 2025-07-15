package com.itxiaodao.mapper;

import com.itxiaodao.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //增
      //基本新增
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

      //主键返回
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void rbInsert(Emp emp);


    //删
      //根据id删除
    @Delete("delete from emp where id = #{id}")
    public void deleteById(Integer id);


    public void deleteByIds(List<Integer> ids);

    //改
      //基本更改
    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, " +
            "image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, " +
            "update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

      //动态更改
    public void moUpdate(Emp emp);


    //查
      //根据id查询
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

      //条件查询
    @Select("select * from emp where name like concat('%',#{name},'%') " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

      //动态查询
    public List<Emp> moList(String name, Short gender, LocalDate begin, LocalDate end);
}
