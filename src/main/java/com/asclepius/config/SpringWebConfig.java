package com.asclepius.config;

import com.asclepius.common.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;

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
				.addPathPatterns(Constants.INTERCEPT_PREFIX)
				.addPathPatterns(Constants.VALIDITY_PREFIX);
	}

	@Override
	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(new MediaType("application", "json", StandardCharsets.UTF_8), new MediaType(
				"text", "xml", StandardCharsets.UTF_8));
	}
}
