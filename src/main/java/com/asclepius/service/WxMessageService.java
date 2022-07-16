package com.asclepius.service;

import com.asclepius.common.Constants;
import com.asclepius.dao.VerifyDao;
import com.asclepius.pojo.WxTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * WxMessageServiceImpl
 *
 * @author luolinyuan
 * @date 2022/6/26
 **/
@Service("wxMessageServiceImpl")
public class WxMessageService {

	private VerifyDao verifyDao;

	@Autowired
	public void setVerifyDao(VerifyDao verifyDao) {
		this.verifyDao = verifyDao;
	}

	public String responseVerifyCode(WxTextMessage resultMessage) {
		//此时的ToUser就是接收时的用户openid
		resultMessage.setContent(verifyDao.getVerifyCode(resultMessage.getToUserName()).replace(Constants.CODE_PREFIX,
				""));
		return resultMessage.toString();
	}
}
