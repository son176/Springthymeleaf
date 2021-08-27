package com.saleproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.saleproduct.interceptor.Globalinterceptor;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	Globalinterceptor globalinterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalinterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/admin/**","/assets/**");
	}
}
