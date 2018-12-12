package com.tearsmart.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2018-12-05
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
	UserArgumentResolver userArgumentResolver;

	// @Autowired
	// AccessInterceptor accessInterceptor;

    /**
     * 添加参数解析类到 HandlerMethodArgumentResolver 集合中,
     *
     * @param argumentResolvers
     */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	}
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
