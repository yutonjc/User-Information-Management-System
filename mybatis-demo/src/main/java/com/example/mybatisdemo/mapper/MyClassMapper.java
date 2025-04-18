package com.example.mybatisdemo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisdemo.entity.MyClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyClassMapper extends BaseMapper<MyClass> {
    @Select("select * from tb_class where id=#{id}")
    MyClass findById(int id);
}
