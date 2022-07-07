package com.asclepius.utils;

import com.asclepius.mapper.DoctorMapper;
import com.asclepius.mapper.ScheduleMapper;
import com.asclepius.pojo.Doctor;
import com.asclepius.pojo.DoctorExample;
import com.asclepius.pojo.Schedule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * 生成排班数据 让医生随机上一年的班！！
 *
 * @author luolinyuan
 * @date 2022/7/7
 **/
@SpringBootTest
@Deprecated
@Ignore
@RunWith(SpringRunner.class)
public class GenSchedule {
	@Resource
	ScheduleMapper scheduleMapper;

	@Resource
	DoctorMapper doctorMapper;

	@Test
	public void insertMorningSchedule() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		DoctorExample doctorExample = new DoctorExample();
		doctorMapper.selectByExample(doctorExample);
		for (int i = 0; i < 365; i++) {
			Long time = calendar.getTimeInMillis();
			for (int dId = 1; dId <= 23; dId++) {
				doctorExample.clear();
				doctorExample.createCriteria().andDIdEqualTo(dId);
				List<Doctor> doctors = doctorMapper.selectByExample(doctorExample);
				Schedule schedule = new Schedule();
				int j = (int) (Math.random() * doctors.size());
				for (; j < doctors.size(); j++) {
					schedule.setDocId(doctors.get(j).getDocId());
					schedule.setScStartTime(time);
					schedule.setNum(Math.random() < 0.5 ? 30 : 50);
					schedule.setDocPrice(schedule.getNum() == 30 ? 50.0F : 30.0F);
					scheduleMapper.insert(schedule);
				}
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

	@Test
	public void insertNoonSchedule() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 14);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		DoctorExample doctorExample = new DoctorExample();
		doctorMapper.selectByExample(doctorExample);
		for (int i = 0; i < 365; i++) {
			Long time = calendar.getTimeInMillis();
			for (int dId = 1; dId <= 23; dId++) {
				doctorExample.clear();
				doctorExample.createCriteria().andDIdEqualTo(dId);
				List<Doctor> doctors = doctorMapper.selectByExample(doctorExample);
				Schedule schedule = new Schedule();
				int j = (int) (Math.random() * doctors.size());
				for (; j < doctors.size(); j++) {
					schedule.setDocId(doctors.get(j).getDocId());
					schedule.setScStartTime(time);
					schedule.setNum(Math.random() < 0.5 ? 30 : 50);
					schedule.setDocPrice(schedule.getNum() == 30 ? 50.0F : 30.0F);
					scheduleMapper.insert(schedule);
				}
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
