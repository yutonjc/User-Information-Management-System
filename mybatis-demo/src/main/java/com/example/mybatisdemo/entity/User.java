package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

//实体类，对应数据库中的表user，名字可以一至
@Data
@TableName("user")
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer classId;
    private String email;
    @TableField(exist = false)//说明下面的属性不存在对应的表中
    private MyClass myClass;//
    @TableField(exist = false)
    private List<Order> order;//一对多
}
