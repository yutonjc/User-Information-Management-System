package com.example.mybatisdemo.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
    @Autowired//自动装配
    UserMapper userMapper;
    @GetMapping("/User/findByPage")
    public IPage findByPage(){
        Page<User> page=new Page<>(1,4);
        IPage iPage=userMapper.selectPage(page,null);
        System.out.println(iPage);
        return iPage;
    }
}
