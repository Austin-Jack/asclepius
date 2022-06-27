package com.asclepius.utils;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2022/6/26
 **/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 各种加密解密
 */
public class DecriptUtil {

	public static String SHA1(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(decript.getBytes());
			byte[] messageDigest = digest.digest();
			// Create Hex String
			StringBuilder hexString = new StringBuilder();
			// 字节数组转换为 十六进制 数
			for (byte b : messageDigest) {
				String shaHex = Integer.toHexString(b & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}