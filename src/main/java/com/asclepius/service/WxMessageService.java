package com.asclepius.service;

import com.asclepius.pojo.WxTextMessage;

/**
 * WxMessageService
 *
 * @author luolinyuan
 * @date 2022/6/26
 **/
public interface WxMessageService {
	String responseVerifyCode(WxTextMessage received);
}
