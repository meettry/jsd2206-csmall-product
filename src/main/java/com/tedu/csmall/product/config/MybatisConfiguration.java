package com.tedu.csmall.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Mybatis的mapper
 * @author Meettry
 * @date 2022/9/22 11:32
 */
@Configuration
@MapperScan("com.tedu.csmall.product.mapper")//mapper包路径
public class MybatisConfiguration {
    public MybatisConfiguration() {
        System.out.println("创建配置类：MybatisConfiguration");
    }
}
