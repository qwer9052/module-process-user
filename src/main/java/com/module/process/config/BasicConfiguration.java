package com.module.process.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 서비스의 기본 설정값 초기화
 *
 */
@Configuration
@ComponentScan(
        basePackages = {
                "com.module.domain.user",
        }
)
public class BasicConfiguration {


}
