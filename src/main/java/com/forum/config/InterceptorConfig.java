package com.forum.config;

import com.forum.framework.interceptor.AuthVerifyInterceptor;
import com.forum.framework.interceptor.ParamPertreamentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// spring boot 的拦截器配置
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private AuthVerifyInterceptor authVerifyInterceptor;
    @Autowired
    private ParamPertreamentInterceptor paramPertreamentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器
        registry.addInterceptor(authVerifyInterceptor)
                // 添加需要被拦截的路由
                .addPathPatterns("/**")
                //  添加不需要被拦截的路由
                .excludePathPatterns(Stream.of("/register-info/login", "/register-info/register", "/register-info/logout").collect(Collectors.toList()));
//        registry.addInterceptor(paramPertreamentInterceptor);
    }
}
