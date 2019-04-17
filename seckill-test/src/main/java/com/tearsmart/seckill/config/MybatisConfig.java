package com.tearsmart.seckill.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 * mybatis 配置文件
 * </p>
 * @author tear-smart
 * @date 2018-12-05
 */
@Configuration
public class MybatisConfig {
    /**
     * SQL执行效率插件
     * 设置 dev test 环境开启
     */
    @Bean
    // @Profile({"dev", "test"})
    public PerformanceInterceptorPlus performanceInterceptorPlus() {
        // 参数：maxTime SQL 执行最大时长，超过自动停止运行，有助于发现问题。
        // 参数：format SQL SQL是否格式化，默认false
        return new PerformanceInterceptorPlus()
                .setFormat(true)
                .setWriteInLog(true);
    }


    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
