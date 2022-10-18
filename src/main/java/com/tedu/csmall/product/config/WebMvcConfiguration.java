package com.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Mvc框架的配置
 * @author Meettry
 * @date 2022/9/28 16:23
 */
@Slf4j
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    public WebMvcConfiguration() {
        log.debug("创建配置类WebMvcConfiguration");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(3600);
    }
}
