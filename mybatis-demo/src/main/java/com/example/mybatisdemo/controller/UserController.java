package com.example.mybatisdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired//自动注入，把usermapper注入到spring容器
    UserMapper userMapper;
    @GetMapping("/query1")
    public String query1() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return "查询所有用户";
    }
    @GetMapping("/query2")
    public List query2() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @GetMapping("/query3")
    public User query3(){
        int id= 1;
        return userMapper.selectById(id);
    }
    @GetMapping("/query4")
    public User query4(int id){
        return userMapper.selectById(id);
    }
    @GetMapping("/query5")
    public List<User> query5(){
        List<User> list=userMapper.selectBatchIds(Arrays.asList(1,2,3,4,5));
        System.out.println(list);
        list.forEach(System.out::println);
        return list;
    }
    @GetMapping("/query6")
    public List<User> query6(){
        HashMap<String,Object> map=new HashMap<>();
        map.put("name","马云");
        map.put("age",29);
        List<User> list = userMapper.selectByMap(map);
        System.out.println(list);
        return list;
    }
    @GetMapping("/query7")
    public List<User> query7(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","马云").gt("age",19);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
        return list;
    }
    @GetMapping("/query8")
    public List<User> query8(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","马").likeRight("age",2);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
        return list;
    }
    @GetMapping("/findByPage/{page}/{size}")
    public IPage findByPage(@PathVariable("page") Integer page,
                            @PathVariable("size") Integer size){
        Page<User> pages = new Page<>(page,size);
        IPage iPage = userMapper.selectPage(pages, null);
        System.out.println(iPage);
        return iPage;
    }
    @PostMapping("/insert1")
    public String insert1(User user){
        int i = userMapper.insert(user);
        if (i>0){
            return "插入成功";
        }
        else return "插入失败";
    }
    @PostMapping("/insert2")
    public String insert2(){
        User user = new User();
        user.setId(18);
        user.setName("李四");
        user.setAge(19);
        user.setEmail("test13@gpnu.cn");
        user.setClassId(1001);
        int i=userMapper.insert(user);
        if (i>0){
            System.out.println("插入成功");
        }else System.out.println("插入失败");
        return "插入成功";
    }
    @PostMapping("/insert3")
    public int insert3(@RequestBody User user){
        return userMapper.insert(user);

    }
    @GetMapping("/update1")
    public String update1(){
        User user = new User();
        user.setId(17);
        user.setAge(21);
        user.setName("New");
        int id = userMapper.updateById(user);
        if (id>0){
        System.out.println("更新成功");
        System.out.println(user);
        }
        return "更新成功";
    }
    @GetMapping("/update2")
    public String update2(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name","New");
        User user = new User();
        user.setAge(30);
        int i = userMapper.update(user,userUpdateWrapper);
        System.out.println("i:"+i);
        return "更新成功";
    }
     @PutMapping("/update3")
     public int update3(@RequestBody User user){
         return userMapper.updateById(user);
     }

    //删除
    @GetMapping("/delete1")
    public void delete1(String id){
        int m = userMapper.deleteById(id);
        System.out.println(m);
    }
    @GetMapping("/delete2")
    public void delete2(){
        int m = userMapper.deleteBatchIds(Arrays.asList(16,18));
        System.out.println(m);
    }
    @GetMapping("/delete3")
    public void delete3(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","sandy");
        int result = userMapper.deleteByMap(map);
        System.out.println("result"+result);
    }
    @DeleteMapping("/delete4/{userId}")
    public int delete(@PathVariable("userId") Integer userId){
        int row = userMapper.deleteById(userId);
        return row;

    }
}





