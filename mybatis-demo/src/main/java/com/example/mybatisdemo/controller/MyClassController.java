package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.MyClass;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.MyClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class MyClassController {
    @Autowired
    MyClassMapper myClassMapper;

    @GetMapping("/myclass/query")
    public List<MyClass> myClassAndQuery() {
        List<MyClass> list = myClassMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @GetMapping("/myclass/query2")
    public MyClass query4(int id){
        return myClassMapper.selectById(id);
    }

    @PostMapping("/myclass/insert")
    public int insert(@RequestBody MyClass myClass) {
        return myClassMapper.insert(myClass);
    }
    @PutMapping("/myclass/update")
    public int update(@RequestBody MyClass myClass){
        return myClassMapper.updateById(myClass);
    }

    @DeleteMapping("/myclass/delete/{classId}")
    public int delete(@PathVariable("classId") Integer classId){
        return myClassMapper.deleteById(classId);

    }
}
