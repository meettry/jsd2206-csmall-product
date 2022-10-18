package com.tedu.csmall.product.preload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CachePreload implements ApplicationRunner {

    public CachePreload() {
        log.debug("创建ApplicationRunner接口的实现对象:CachePreload");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("开始处理缓存预热");
    }
}
