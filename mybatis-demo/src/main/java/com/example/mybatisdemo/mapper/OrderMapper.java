package com.example.mybatisdemo.mapper;
import com.example.mybatisdemo.entity.Order;
import com.example.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface OrderMapper {
    @Select("select * from tb_order where id=#{id}")
    List<Order> findById(int id);
    @Insert("insert into tb_order values(#{id},#{orderTime},#{total},#{userId})")
    int add(Order order);
    @Update("update tb_order set orderTime=#{orderTime},total=#{total} where id=#{id}")
    int update(Order order);
    @Delete("delete from tb_order where id = #{id}")
    int delete(int id);
    @Select("select * from tb_order")
    List<User> getAll();
    @Select("select * from tb_order")
    @Results(
            {//要做表中的属性和类中的属性的映射关系，column是表中的属性，property是类中的属性
                    @Result(column = "id",property = "id"),
                    @Result(column = "orderTime",property = "orderTime"),
                    @Result(column = "total",property = "total"),
                    @Result(column = "user_id",property = "userId"),
                    //通过user_id去查找班级名称，将class_id传入com.example.mybatisdemo.mapper.MyClassMapper.selectById
                    @Result(column = "user_id",property = "user",javaType = User.class,
                            one = @One(select = "com.example.mybatisdemo.mapper.UserMapper.findById"))

            }
    )
    public  List<Order> getOrderAndUser() ;
}
