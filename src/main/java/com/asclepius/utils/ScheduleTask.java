package com.asclepius.utils;

import com.asclepius.mapper.ScheduleMapper;
import com.asclepius.pojo.Schedule;
import com.asclepius.pojo.ScheduleExample;
import com.asclepius.service.DoctorService;
import com.asclepius.service.ScheduleService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import static com.asclepius.common.Constants.*;

/**
 * ScheduleTask
 *
 * @author luolinyuan
 * @date 2022/7/17
 **/
@Component
public class ScheduleTask implements ApplicationRunner {

	@Resource
	ScheduleMapper scheduleMapper;

	@Resource
	RedisTemplate<String, Serializable> redisTemplate;

	@Resource
	DoctorService doctorService;

	@Resource
	ScheduleService scheduleService;

	/**
	 * 每天2点添加后一天的排班信息
	 **/
	@Scheduled(cron = "0 0 2 * * ?")
	public void putAppointmentCache() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, 12);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		ScheduleExample example = new ScheduleExample();
		example.createCriteria().andScStartTimeBetween(System.currentTimeMillis(), calendar.getTimeInMillis());
		List<Schedule> schedules = scheduleMapper.selectByExample(example);
		String key;
		for (Schedule schedule : schedules) {
			key = HASH_KEY_PREFIX + schedule.getsId();
			if (redisTemplate.opsForHash().putIfAbsent(key, REMAIN_FILED_KEY, schedule.getNum())) {
				redisTemplate.expire(key, Duration.ofDays(SCHEDULE_SCOPE));
			}
		}
	}

	/**
	 * 每天凌晨1点更新
	 **/
	@Scheduled(cron = "0 0 1 * * ?")
	public void putScheduleCache() {
		for (int i = 1; i <= DEPARTMENT_NUM; i++) {
			scheduleService.getDepartmentSchedule(i);
		}
	}


	public void putDoctorCache() {
		for (int i = 1; i <= DEPARTMENT_NUM; i++) {
			doctorService.getDepartmentDoctorNum(i);
			doctorService.getDoctorsByDId(i, 1);
			doctorService.getDepartmentDoctorNum(i);
		}
	}

	/**
	 * 启动时刷入缓存
	 *
	 * @param args
	 * @return void
	  **/
	@Override
	public void run(ApplicationArguments args) throws Exception {
		putScheduleCache();
		putDoctorCache();
	}
}
