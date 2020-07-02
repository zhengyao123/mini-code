package com.zy.minicoderedis.redislimit.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * date:  2020-07-02 16:03
 *
 * @author zhengyao
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(accessInterceptor()).addPathPatterns("/limit/**");
        super.addInterceptors(registry);
    }

    @Bean
    public AccessInterceptor accessInterceptor(){
        return new AccessInterceptor();
    }
}
