package com.tedu.csmall.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Meettry
 * @date 2022/9/22 11:32
 */
@Configuration
@MapperScan("com.tedu.csmall.product.mapper")
public class MybatisConfiguration {
    public MybatisConfiguration() {
        System.out.println("创建配置类：MybatisConfiguration");
    }
}
