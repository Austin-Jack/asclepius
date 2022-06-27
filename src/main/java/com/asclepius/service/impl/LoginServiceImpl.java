package com.asclepius.service.impl;

import com.asclepius.dao.VerifyDao;
import com.asclepius.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginServiceImpl
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {
	private VerifyDao verifyDao;

	@Autowired
	public void setVerifyDao(VerifyDao verifyDao) {
		this.verifyDao = verifyDao;
	}

	@Override
	public String verify(String code) {
		return verifyDao.Verify(code);
	}
}
