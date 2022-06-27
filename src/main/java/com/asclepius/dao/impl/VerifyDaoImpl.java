package com.asclepius.dao.impl;

import com.asclepius.common.Constants;
import com.asclepius.dao.VerifyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * VerifyDaoImpl
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
@Component
public class VerifyDaoImpl implements VerifyDao {
	private RedisTemplate<String, String> stringRedisTemplate;


	@Autowired
	public void setStringRedisTemplate(RedisTemplate<String, String> stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	@Override
	public String getVerifyCode(String usrOpenId) {
		String code;
		do {
			code = generateCode();
		} while (Boolean.TRUE.equals(stringRedisTemplate.hasKey(code)));
		stringRedisTemplate.opsForValue().set(code, usrOpenId, 5, TimeUnit.MINUTES);
		return code;
	}

	@Override
	public String Verify(String verCode) {
		return stringRedisTemplate.opsForValue().get(Constants.CODE_PREFIX + verCode);
	}

	public String generateCode() {
		StringBuilder codeSb = new StringBuilder();
		codeSb.append(Constants.CODE_PREFIX);
		for (int i = 0; i < Constants.VERIFY_LEN; i++) {
			codeSb.append((int) (Math.random() * 10));
		}
		return codeSb.toString();
	}
}
