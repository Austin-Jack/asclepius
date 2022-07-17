package com.asclepius.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * RedisScriptConfig
 *
 * @author luolinyuan
 * @date 2022/7/17
 **/
@Configuration
@Slf4j
public class RedisScriptConfig {
	@Resource
	RedisTemplate<String, Serializable> redisTemplate;

	@Bean
	@SuppressWarnings("rawtypes")
	public DefaultRedisScript<List> secondKillScript() {
		DefaultRedisScript<List> script = new DefaultRedisScript<>();
		script.setResultType(List.class);
		script.setLocation(new ClassPathResource("secondKill.lua"));
		loadRedisScript(script, "secondKill");
		return script;
	}

	@Bean
	public DefaultRedisScript<Long> cancelAppointmentScript() {
		DefaultRedisScript<Long> script = new DefaultRedisScript<>();
		script.setResultType(Long.class);
		script.setLocation(new ClassPathResource("cancelAppointment.lua"));
		loadRedisScript(script, "cancelAppointment");
		return script;
	}

	private <T> void  loadRedisScript(DefaultRedisScript<T> redisScript, String luaName) {
		try {
			List<Boolean> results =
					Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().scriptExists(redisScript.getSha1());
			if (Boolean.FALSE.equals(Objects.requireNonNull(results).get(0))) {
				String sha = redisTemplate.getConnectionFactory().getConnection().scriptLoad(scriptBytes(redisScript));
				log.info("预加载lua脚本成功：{}, sha=[{}]", luaName, sha);
			}
		} catch (Exception e) {
			log.error("预加载lua脚本异常：{}", luaName, e);
		}
	}

	private byte[] scriptBytes(RedisScript<?> script) {
		return this.redisTemplate.getStringSerializer().serialize(script.getScriptAsString());
	}
}
