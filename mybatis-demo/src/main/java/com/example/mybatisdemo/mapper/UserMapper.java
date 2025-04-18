package com.example.mybatisdemo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper//
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where id=#{id}")
    User findById(int id);
}
