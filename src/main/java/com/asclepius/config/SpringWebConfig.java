package com.asclepius.config;

import com.asclepius.common.Constants;
import com.asclepius.controller.interceptor.AccessTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * SpringWebConfig
 *
 * @author luolinyuan
 * @date 2022/7/1
 **/
@Configuration
public class SpringWebConfig extends WebMvcConfigurationSupport {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AccessTokenInterceptor())
				.addPathPatterns(Constants.INTERCEPT_PREFIX);
	}
}
