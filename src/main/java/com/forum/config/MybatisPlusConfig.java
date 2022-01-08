package com.forum.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.forum.mapper")
public class MybatisPlusConfig {
}
