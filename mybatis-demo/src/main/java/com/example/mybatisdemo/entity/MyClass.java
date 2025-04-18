package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data//生成set , get and tostring方法
@TableName("tb_class")
public class MyClass {
    public Integer id;
    public String className;
}
