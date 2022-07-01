package com.asclepius.utils;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2022/6/30
 **/
public class GenerateMockData {
	static final int OPENID_LEN = 28;

	/*生成openID*/
	public static String generateOpenID() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < OPENID_LEN; i++) {
			double random = Math.random();
			int index = (int) (Math.random() * 26);
			if (random < 0.33) {
				sb.append(Character.toChars('a' + index));
			} else if (random < 0.66) {
				sb.append(Character.toChars('A' + index));
			} else {
				sb.append((int) (random * 10));
			}
		}
		return sb.toString();
	}
}
