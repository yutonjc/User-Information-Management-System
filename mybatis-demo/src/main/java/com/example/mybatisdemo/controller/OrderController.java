package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.Order;
import com.example.mybatisdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @GetMapping("/order/query")
    public List<Order> myClasseAndQuery(int id) {
        List<Order> list = orderMapper.findById(id);
        System.out.println(list);
        return list;
    }

    @PostMapping("/order/add")
    public String add(Order order){
        int i = orderMapper.add(order);
        if (i>0){
            return "插入成功";
        }else return "插入失败";
    }
    @GetMapping("/order/update")
    public String update(){
        Order order = new Order();
        order.setId(8);
        order.setOrderTime(new Date(2023-07-02));
        order.setTotal(1234);
        order.setUserId(5);
        int id = orderMapper.update(order);
        System.out.println("更新成功");
        System.out.println(id);
        return "更新成功";
    }
    @GetMapping("/order/delete")
    public String delete(int id){
        int result = orderMapper.delete(id);
        System.out.println(result);
        return "删除成功";
    }

}
