package com.zy.pctransaction.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * date:  2020-06-29 15:22
 *
 * @author zhengyao
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * addInterceptor：需要一个实现HandlerInterceptor接口的拦截器实例
     * addPathPatterns：用于设置拦截器的过滤路径规则
     * excludePathPatterns：用于设置不需要拦截的过滤规则
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());
    }
}
