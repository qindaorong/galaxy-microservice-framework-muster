package com.galaxy.microservice.orm;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
@ComponentScan("com.galaxy.microservice")
public class AutoConfigure {

	/**
	 * 分页插件
	 */
	@Bean
	@ConditionalOnMissingBean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	/**
	 * 性能分析
	 */
	@Bean
	@ConditionalOnProperty(value="mybatis.performance.enable",havingValue = "true")
	@ConditionalOnMissingBean
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		performanceInterceptor.setWriteInLog(true);
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}
}
