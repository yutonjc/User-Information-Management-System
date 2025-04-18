package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.UserOldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserOldController {
    @Autowired
    UserOldMapper userOldMapper;
    @GetMapping("/find1")
    public String find(){
        List<User> list = userOldMapper.getAll();
        System.out.println(list);
        return "查询成功";
    }
    @GetMapping("/find2")
    public User find2(){
        int id = 1;
        return userOldMapper.findByid(id);
    }
    @PostMapping("/add")
    public String add(User user){
        int i = userOldMapper.add(user);
        if (i>0){
            return "插入成功";
        }else return "插入失败";
    }
    @GetMapping("/update3")
    public String update3(){
        User user = new User();
        user.setId(16);
        user.setAge(21);
        user.setName("New");
        user.setClassId(1001);
        user.setEmail("test16");
        int id = userOldMapper.update(user);
        System.out.println("更新成功");
        System.out.println(user);
        return "更新成功";
    }
    @GetMapping("/delete4")
    public void delete4(){
        int result = userOldMapper.delete(15);
        System.out.println(result);
    }
}
