package com.agri.agribigdata.config;

import com.agri.agribigdata.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //addPathPatterns配置拦截的资源, excludePathPatterns配置不需要拦截的资源
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/register");
    }
}
