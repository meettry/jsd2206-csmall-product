package com.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Mybatis的mapper
 *
 * @author Meettry
 * @date 2022/9/22 11:32
 */
@Slf4j
@Configuration
@MapperScan("com.tedu.csmall.product.mapper")//mapper包路径
public class MybatisConfiguration {
    public MybatisConfiguration() {
        log.debug("创建配置类：MybatisConfiguration");
    }
}
