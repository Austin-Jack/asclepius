package com.asclepius.config;

import com.asclepius.mapper.ScheduleMapper;
import com.asclepius.pojo.Schedule;
import com.asclepius.pojo.ScheduleExample;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import static com.asclepius.common.Constants.*;

/**
 * @Author sny
 * @CreateTime 2022-07-01  19:11
 * @Description TODO
 * @Version 1.0
 */
@Component
public class InitRedis {



	@Resource
	ScheduleMapper scheduleMapper;

	@Resource
	RedisTemplate<String, Serializable> redisTemplate;

	@PostConstruct // 构造函数之后执行
	public void init() {
		initRedis();
	}

	private void initRedis() {
		//获得七天后下午14点的时间戳
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, SCHEDULE_SCOPE);
		calendar.set(Calendar.HOUR_OF_DAY, NOON_WORKING_TIME);
		ScheduleExample scheduleExample = new ScheduleExample();
		//查询这七天范围内的所有排班 PREHEAT_TIME为预热时间
		scheduleExample.createCriteria().andScStartTimeBetween(System.currentTimeMillis() + PREHEAT_TIME,
				calendar.getTimeInMillis());
		List<Schedule> schedules = scheduleMapper.selectByExample(scheduleExample);
		for (Schedule schedule : schedules) {
			//当没有这样的key时(多机后端 单机redis) 存入这样的hash
			redisTemplate.opsForHash().putIfAbsent(HASH_KEY_PREFIX + schedule.getsId(), REMAIN_FILED_KEY, schedule.getNum());
			redisTemplate.opsForHash().putIfAbsent(HASH_KEY_PREFIX+ schedule.getsId(), TOTAL_FILED_KEY, schedule.getNum());
		}
	}
}
