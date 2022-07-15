package com.asclepius.service;

import com.asclepius.dto.DoctorScheduleDTO;
import com.asclepius.mapper.DepartmentMapperExt;
import com.asclepius.mapper.DoctorMapper;
import com.asclepius.mapper.ScheduleMapper;
import com.asclepius.pojo.Doctor;
import com.asclepius.pojo.Schedule;
import com.asclepius.pojo.ScheduleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author sny
 * @CreateTime 2022-07-01  16:00
 * @Description TODO
 * @Version 1.0
 */
@Service
public class ScheduleService {

	private static final Long MORNING_WORK_TIME = 144 * 1000 * 100L;

	private static final int SCHEDULE_SCOPE = 7;

	private static final int NOON_WORK_TIME = 14;

	private static final String SCHEDULE_TIME_FILED = "sc_start_time";

	@Resource
	ScheduleMapper scheduleMapper;

	@Resource
	DepartmentMapperExt departmentMapperExt;

	@Resource
	DoctorMapper doctorMapper;


	public DoctorScheduleDTO getScheduleByDocId(Integer dId, Integer docId) {
		DoctorScheduleDTO dto = departmentMapperExt.getCliByDid(dId);
		Doctor doctor = doctorMapper.selectByPrimaryKey(docId);
		dto.setDocName(doctor.getDocName());
		dto.setDocRank(doctor.getDocRank());
		ScheduleExample example = new ScheduleExample();
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		calendar.set(Calendar.HOUR_OF_DAY, NOON_WORK_TIME);
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

	public List<String>[] getDepartmentSchedule(Integer dId) {
		List<String>[] result = new ArrayList[14];
		Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.HOUR_OF_DAY, 8);
		int i = 0;
		do {
			Long start = c1.getTimeInMillis();
			Long end = start + MORNING_WORK_TIME;
			result[i++] = departmentMapperExt.getDepartmentSchedule(dId, start, end);
			c1.add(Calendar.DAY_OF_MONTH, 1);
		} while (i < 7);
		Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.HOUR_OF_DAY, 14);
		do {
			Long start = c2.getTimeInMillis();
			Long end = start + MORNING_WORK_TIME;
			result[i++] = departmentMapperExt.getDepartmentSchedule(dId, start, end);
			c2.add(Calendar.DAY_OF_MONTH, 1);
		} while (i < 14);
		return result;
	}
}
