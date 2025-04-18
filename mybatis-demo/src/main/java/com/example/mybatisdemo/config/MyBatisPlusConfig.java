package com.example.mybatisdemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//告诉Sping，这是一个配置文件。将下面的配置文件注入到Spring容器中
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor paginationInterceptor(){
        //创建mybatisPlus的拦截器，当作MyBatisPius操作时，会被拦截器拦截
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        //定义一个分页拦截器
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
