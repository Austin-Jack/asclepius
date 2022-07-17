package com.asclepius.config;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

/**
 * LettuceRedisConfig
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
@Configuration
public class LettuceRedisConfig {

	private static final long CACHE_HOURS = 24;

	@Bean
	public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
		RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Integer.class));
		return redisTemplate;
	}

	@Bean("scheduleKeyGenerator")
	public KeyGenerator scheduleKeyGenerator() {
		return (o, method, parameters) -> "[" + parameters[0] + "," + DateUtil.formatDate(new Date()) + "]";
	}

	@Bean("doctorKeyGenerator")
	public KeyGenerator doctorKeyGenerator() {
		return (o, method, parameters) -> "[" + parameters[0] + "," + parameters[1] + "]";
	}

	@Bean("scheduleCacheManager")
	public RedisCacheManager ScheduleCacheManager(LettuceConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofHours(CACHE_HOURS))   //设置缓存失效时间
				.disableCachingNullValues();

		return RedisCacheManager
				.builder(connectionFactory)
				.cacheDefaults(config)
				.build();
	}

	@Bean("defaultRedisCacheManager")
	@Primary
	public RedisCacheManager defaultRedisCacheManager(LettuceConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ZERO)   //设置缓存失效时间
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
				.disableCachingNullValues();

		return RedisCacheManager
				.builder(connectionFactory)
				.cacheDefaults(config)
				.build();
	}
}
