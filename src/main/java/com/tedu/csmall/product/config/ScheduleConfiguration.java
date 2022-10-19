package com.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 计划任务配置类
 */
@Configuration
@Slf4j
@EnableScheduling
public class ScheduleConfiguration {
    public ScheduleConfiguration() {
        log.debug("生成配置类:ScheduleConfiguration");
    }
}
