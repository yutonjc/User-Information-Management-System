package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.Order;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.OrderMapper;
import com.example.mybatisdemo.mapper.UserManyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManyController {
    @Autowired
    UserManyMapper userManyMapper;
    @Autowired
    OrderMapper orderMapper;
    @GetMapping("/many/query")
    public List<User> query1(){
        List<User> list = userManyMapper.getUserAndClass();
        System.out.println(list);
        return list;
    }
    @GetMapping("/many/queryorder")
    public List<User> query2(){
        List<User> list = userManyMapper.getUserAndOrder();
        list.forEach(System.out::println);
        return list;
    }
    @GetMapping("/many/classAndOrderQuery")
    public List<User> query3(){
        List<User> list = userManyMapper.getUserAndClassAndOrder();
        list.forEach(System.out::println);
        return list;
    }
    @GetMapping("/many/OrderAndClassQuery")
    public List<Order> query4(){
        List<Order> list = orderMapper.getOrderAndUser();
        list.forEach(System.out::println);
        return list;
    }

}
