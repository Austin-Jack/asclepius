package com.asclepius.service;

import com.asclepius.dto.DoctorScheduleDTO;
import com.asclepius.mapper.DepartmentMapperExt;
import com.asclepius.mapper.DoctorMapper;
import com.asclepius.mapper.ScheduleMapper;
import com.asclepius.pojo.Doctor;
import com.asclepius.pojo.Schedule;
import com.asclepius.pojo.ScheduleExample;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.asclepius.common.Constants.*;

/**
 * @Author sny
 * @CreateTime 2022-07-01  16:00
 * @Description TODO
 * @Version 1.0
 */
@Service
public class ScheduleService {

	private static final String SCHEDULE_TIME_FILED = "sc_start_time";

	@Resource
	ScheduleMapper scheduleMapper;

	@Resource
	DepartmentMapperExt departmentMapperExt;

	@Resource
	DoctorMapper doctorMapper;

	@Cacheable(value = "doctorSchedule", condition = "#dId between {1,23}", sync = true,
			keyGenerator = "scheduleKeyGenerator",cacheManager = "doctorScheduleCacheManager")
	public DoctorScheduleDTO getScheduleByDocId(Integer docId, Integer dId) {
		DoctorScheduleDTO dto = departmentMapperExt.getCliByDid(dId);
		Doctor doctor = doctorMapper.selectByPrimaryKey(docId);
		dto.setDocName(doctor.getDocName());
		dto.setDocRank(doctor.getDocRank());
		ScheduleExample example = new ScheduleExample();
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		calendar.set(Calendar.HOUR_OF_DAY, NOON_WORKING_TIME);
		calendar.add(Calendar.DAY_OF_MONTH, SCHEDULE_SCOPE);
		example.createCriteria().andDocIdEqualTo(docId).andScStartTimeBetween(System.currentTimeMillis(),
				calendar.getTimeInMillis());
		example.setOrderByClause(SCHEDULE_TIME_FILED);
		List<Schedule> schedules = scheduleMapper.selectByExample(example);
		dto.setTimes(schedules.stream().map(schedule -> {
			DoctorScheduleDTO.ScheduleTime scheduleTime = new DoctorScheduleDTO.ScheduleTime();
			scheduleTime.setTime(schedule.getScStartTime());
			scheduleTime.setsId(schedule.getsId());
			return scheduleTime;
		}).collect(Collectors.toList()));
		if (schedules.size() != 0) {
			dto.setApCost(schedules.get(0).getDocPrice());
		}
		return dto;
	}

	@Cacheable(value = "schedule", condition = "#dId between {1,23}", sync = true,
			keyGenerator = "scheduleKeyGenerator", cacheManager = "scheduleCacheManager")
	public String[][] getDepartmentSchedule(Integer dId) {
		String[][] result = new String[14][];
		Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		c1.set(Calendar.HOUR_OF_DAY, MORNING_WORKING_TIME - 1);
		int i = 0;
		do {
			long start = c1.getTimeInMillis();
			long end = start + MORNING_WORK_PERIOD;
			result[i++] = departmentMapperExt.getDepartmentSchedule(dId, start, end).toArray(new String[]{});
			c1.add(Calendar.DAY_OF_MONTH, 1);
		} while (i < 7);
		c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		c1.set(Calendar.HOUR_OF_DAY, NOON_WORKING_TIME - 1);
		do {
			long start = c1.getTimeInMillis();
			long end = start + NOON_WORKING_PERIOD;
			result[i++] = departmentMapperExt.getDepartmentSchedule(dId, start, end).toArray(new String[]{});
			c1.add(Calendar.DAY_OF_MONTH, 1);
		} while (i < 14);
		return result;
	}
}
