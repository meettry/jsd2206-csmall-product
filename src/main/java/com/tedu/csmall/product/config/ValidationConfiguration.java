package com.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;

/**
 * Validation配置类
 * @author Meettry
 * @date 2022/9/30 11:44
 */
@Slf4j
public class ValidationConfiguration {

    public ValidationConfiguration() {
        log.debug("创建配置类：ValidationConfiguration");
    }

    @Bean
    public javax.validation.Validator validator(){
        return Validation.byProvider(HibernateValidator.class)
                .configure()       //开始配置Validator
                .failFast(true)    //快速失败,即检查请求参数发现错误时直接视为失败,不进行后面的检查【重要 】
                .buildValidatorFactory()
                .getValidator();
    }
}
