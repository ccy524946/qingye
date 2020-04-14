package com.tx.springbootinterceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器配置类
 */
@Configuration
public class WebappAdrapter implements WebMvcConfigurer {

    /**
     * 将登录拦截器添加进来
     * addPathPatterns()添加拦截
     * excludePathPatterns（）排除拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //实例化登录拦截器，用于注册
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(loginInterceptor.getUrls());
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
