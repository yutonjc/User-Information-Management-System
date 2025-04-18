package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//不使用myBatisPlus,只使用myBatis
//因为做多表查询时，myBatisPlus无能为力
@Mapper
public interface UserOldMapper {
    @Select("select * from user")
    List<User> getAll();
    @Select("select * from user where id= #{id}")
    User findByid(int id);
    @Insert("insert into user values(#{id},#{name},#{age},#{classId},#{email})")
    int add(User user);
    @Update("update user set name=#{name},class_id=#{classId},age=#{age},email=#{email} where id=#{id}")
    int update(User user);
    @Delete("delete from user where id = #{id}")
    int delete(int id);
}
