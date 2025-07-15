package com.itxiaodao;

import com.itxiaodao.mapper.EmpMapper;
import com.itxiaodao.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("zhangsan");
        emp.setName("张三");
        emp.setGender((short) 1);
        emp.setImage("image.jpg");
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2023, 1, 1));
        emp.setDeptId(1);
        emp.setCreateTime(LocalDate.from(LocalDateTime.now()));
        emp.setUpdateTime(LocalDate.from(LocalDateTime.now()));

        empMapper.insert(emp);
        System.out.println("新增成功");
    }

    @Test
    public void testRbInsert() {
        Emp emp = new Emp();
        emp.setUsername("lisi");
        emp.setName("李四");
        emp.setGender((short) 0);
        emp.setImage("image2.jpg");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2024, 1, 1));
        emp.setDeptId(2);
        emp.setCreateTime(LocalDate.from(LocalDateTime.now()));
        emp.setUpdateTime(LocalDate.from(LocalDateTime.now()));

        empMapper.rbInsert(emp);
        System.out.println("返回主键ID: " + emp.getId());
    }

    @Test
    public void testDeleteById() {
        empMapper.deleteById(1);
        System.out.println("根据ID删除成功");
    }

    @Test
    public void testDeleteByIds() {
        List<Integer> ids = Arrays.asList(2, 3);
        empMapper.deleteByIds(ids);
        System.out.println("批量删除成功");
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(4); // 假设4是存在的ID
        emp.setUsername("wangwu");
        emp.setName("王五");
        emp.setGender((short) 1);
        emp.setImage("image3.jpg");
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2022, 5, 1));
        emp.setDeptId(3);
        emp.setUpdateTime(LocalDate.from(LocalDateTime.now()));

        empMapper.update(emp);
        System.out.println("更新成功");
    }

    @Test
    public void testMoUpdate() {
        Emp emp = new Emp();
        emp.setId(4); // 假设4是存在的ID
        emp.setName("王五-更新");
        empMapper.moUpdate(emp);
        System.out.println("动态更新成功");
    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(4);
        System.out.println(emp);
    }

    @Test
    public void testList() {
        List<Emp> emps = empMapper.list("张", (short) 1, LocalDate.of(2022, 1, 1), LocalDate.of(2024, 12, 31));
        emps.forEach(System.out::println);
    }

    @Test
    public void testMoList() {
        List<Emp> emps = empMapper.moList(null, null, null, null);
        emps.forEach(System.out::println);
    }

}
