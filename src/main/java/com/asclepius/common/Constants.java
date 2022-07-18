package com.asclepius.common;

/**
 * Constants
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
public interface Constants {

	int DEPARTMENT_NUM = 23;

	String HASH_KEY_PREFIX = "sId_";

	int SCHEDULE_SCOPE = 7;

	long MORNING_WORK_PERIOD = 144 * 1000 * 100L;

	long NOON_WORKING_PERIOD = 144 * 1000 * 100L;

	int MORNING_WORKING_TIME = 8;

	int NOON_WORKING_TIME = 14;

	long PREHEAT_TIME = 5 * 60 * 1000;

	String REMAIN_FILED_KEY = "remain";

	String VALIDITY_PREFIX = "/api/login/validity";

	String CODE_PREFIX = "verifyCode";

	String INTERCEPT_PREFIX = "/api/private/**";

	int VERIFY_LEN = 4;
}
