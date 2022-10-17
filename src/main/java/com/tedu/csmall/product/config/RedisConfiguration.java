package com.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;

@Slf4j
@Configuration
public class RedisConfiguration {

    public RedisConfiguration() {
        log.debug("创建配置类RedisConfiguration");
    }

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Serializable> redisTemplate = new RedisTemplate<>();

        // 设置redis连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 利用值序列化器,将数据转换为JSON对象
        redisTemplate.setValueSerializer(RedisSerializer.json());

        // key序列化器,将数据转换为String对象
        redisTemplate.setKeySerializer(RedisSerializer.string());
        return redisTemplate;
    }
}
