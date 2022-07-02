package com.asclepius.utils;

import com.apifan.common.random.source.PersonInfoSource;
import com.asclepius.pojo.Card;
import com.asclepius.pojo.User;

import java.time.LocalDate;

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

	public static User generateUser() {
		User user = new User();
		user.setAccountId(generateOpenID());
		long time = System.currentTimeMillis();
		user.setGmtCreated(time);
		user.setGmtModified(time);
		return user;
	}

	public static String generateIdentity() {
		LocalDate beginDate = LocalDate.of(1990, 11, 11);
		LocalDate endDate = LocalDate.of(1999, 12, 12);
		if (Math.random() < 0.5) {
			return PersonInfoSource.getInstance().randomMaleIdCard("湖南", beginDate, endDate);
		}
		return PersonInfoSource.getInstance().randomFemaleIdCard("湖南", beginDate, endDate);
	}

	public static String generateName() {
		return PersonInfoSource.getInstance().randomMaleChineseName();
	}

	public static String generatesTelNum() {
		return PersonInfoSource.getInstance().randomChineseMobile();
	}

	public static Card generateCard(User user) {
		Card card = new Card();
		card.setIdentityID(generateIdentity());
		card.setSex(Math.random() < 0.5 ? 1 : 0);
		card.setAge((int) (Math.random() * 100));
		card.setName(generateName());
		card.setTelNumber(generatesTelNum());
		card.setuId(user.getuId());
		return card;
	}
}
