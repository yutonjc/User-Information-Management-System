package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_order")
public class Order
{
    private Integer id;
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date orderTime;

    private Integer total;
    @TableField("user_id")
    private Integer userId;
    @TableField(exist = false)
    private User user;

}
