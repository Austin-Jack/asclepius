package com.asclepius.service;

/**
 * LoginService
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
public interface LoginService {
	/**
	 * 验证登录
	 * @param code 验证码
	 * @return java.lang.String 返回的userId 当验证码不存在时返回null
	  **/
	public String verify(String code);
}
