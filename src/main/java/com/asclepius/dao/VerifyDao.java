package com.asclepius.dao;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
public interface VerifyDao {
	String getVerifyCode(String usrOpenId);

	String  Verify(String verCode);
}
