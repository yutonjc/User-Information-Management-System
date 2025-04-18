package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.MyClass;
import com.example.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserManyMapper {
    //一对一的映射：user中的class_id和tb_class_name一一对应
    @Select("select * from user")
    @Results(
            {//要做表中的属性和类中的属性的映射关系，column是表中的属性，property是类中的属性
                    @Result(column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "age",property = "age"),
                    @Result(column = "class_id",property = "classId"),
                    @Result(column = "email",property = "email"),
                    //通过class_id去查找班级名称，将class_id传入com.example.mybatisdemo.mapper.MyClassMapper.selectById
                    @Result(column = "class_id",property = "myClass",javaType = MyClass.class,
                            one = @One(select = "com.example.mybatisdemo.mapper.MyClassMapper.selectById"))

            }
    )
    public  List<User> getUserAndClass() ;
    @Select("select * from user")
    @Results(
            {//要做表中的属性和类中的属性的映射关系，column是表中的属性，property是类中的属性
                    @Result(column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "age",property = "age"),
                    @Result(column = "class_id",property = "classId"),
                    @Result(column = "email",property = "email"),
                    //通过class_id去查找班级名称，将class_id传入com.example.mybatisdemo.mapper.MyClassMapper.selectById
                    @Result(column = "id",property = "order",javaType = List.class,
                            many = @Many(select = "com.example.mybatisdemo.mapper.OrderMapper.findById"))

            }
    )
    public  List<User> getUserAndOrder() ;

    //3个表的连接查询，同时有一对一和一对多的的映射---查询班级
    @Select("select * from user")
    @Results(
            {//要做表中的属性和类中的属性的映射关系，column是表中的属性，property是类中的属性
                    @Result(column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "age",property = "age"),
                    @Result(column = "class_id",property = "classId"),
                    @Result(column = "email",property = "email"),
                    //通过class_id去查找班级名称，将class_id传入com.example.mybatisdemo.mapper.MyClassMapper.selectById
                    @Result(column = "id",property = "order",javaType = List.class,
                            many = @Many(select = "com.example.mybatisdemo.mapper.OrderMapper.findById")),
                    @Result(column = "class_id",property = "myClass",javaType = MyClass.class,
                            one = @One(select = "com.example.mybatisdemo.mapper.MyClassMapper.selectById"))

            }
    )
    public  List<User> getUserAndClassAndOrder() ;


}
