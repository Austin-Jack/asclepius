package com.asclepius.service;

import com.asclepius.dto.AppointmentDTO;
import com.asclepius.mapper.AppointmentMapper;
import com.asclepius.mapper.AppointmentMapperExt;
import com.asclepius.mapper.CardMapper;
import com.asclepius.pojo.Appointment;
import com.asclepius.pojo.AppointmentExample;
import com.asclepius.dto.AppointmentExtDTO;
import com.asclepius.pojo.Card;
import com.asclepius.pojo.CardExample;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author sny
 * @CreateTime 2022-07-01  19:02
 * @Description TODO
 * @Version 1.0
 */
@Service
public class AppointmentService {
	@Resource
	AppointmentMapper appointmentMapper;

	@Resource
	AppointmentMapperExt appointmentMapperExt;

	@Resource
	RedisTemplate<String, Integer> redisTemplate;

	@Resource(name = "cancelAppointmentScript")
	DefaultRedisScript<Long> cancelAppointmentScript;

	@Resource(name = "secondKillScript")
	@SuppressWarnings("rawtypes")
	DefaultRedisScript<List> secondKillScript;

	@Resource
	CardMapper cardMapper;

	private static final int CREATED = 0;
	private static final int CANCELED = 1;
	private static final int EXPIRED = 2;
	private static final int COMPLETED = 3;

	@SuppressWarnings("unchecked")
	public int addAppointment(AppointmentDTO appointmentDTO) {
		// 执行lua脚本并接受返回值
		List<Long> res = redisTemplate.execute(secondKillScript, Arrays.asList(String.valueOf(appointmentDTO.getcId()),
				"sId_" + appointmentDTO.getsId()));
		// 第一个返回值为剩余数，剩余数大于等于0即预约成功
		Long remain = Objects.requireNonNull(res).get(0);
		if (remain >= 0) {
			Appointment appointment = new Appointment();
			BeanUtils.copyProperties(appointmentDTO, appointment);
			appointment.setApStatus(CREATED);
			// 设置预约号
			appointment.setApNum(Integer.parseInt(String.valueOf(res.get(1))));
			appointment.setApTime(System.currentTimeMillis());
			appointmentMapper.insert(appointment);
		}
		return Integer.parseInt(String.valueOf(remain));
	}

	public boolean cancelAppointment(Integer sId, Integer cId) {
		Long res = redisTemplate.execute(cancelAppointmentScript, Arrays.asList(String.valueOf(cId)
				, "sId_" + sId));
		// 当返回值等于1表示取消成功
		if (Objects.requireNonNull(res) == 1) {
			AppointmentExample appointmentExample1 = new AppointmentExample();
			appointmentExample1.createCriteria().andSIdEqualTo(sId).andCIdEqualTo(cId).andApStatusEqualTo(0);
			Appointment appointment = appointmentMapper.selectByExample(appointmentExample1).get(0);
			// 设置mysql数据库中的预约状态
			appointment.setApStatus(CANCELED);
			AppointmentExample appointmentExample2 = new AppointmentExample();
			appointmentExample2.createCriteria().andSIdEqualTo(sId).andCIdEqualTo(cId);
			appointment.setApId(null);
			appointmentMapper.updateByExampleSelective(appointment, appointmentExample2);
		}
		return res == 1;
	}

	public List<AppointmentExtDTO> selectAppointmentByUId(Integer uId, Integer currPage) {
		return appointmentMapperExt.selectAppointmentByUIdPage(uId, currPage);
	}

	public Integer selectAppointmentCountByUID(Integer uId) {
		CardExample example = new CardExample();
		int count = 0;
		AppointmentExample appointmentExample = new AppointmentExample();
		example.createCriteria().andUIdEqualTo(uId);
		for (Card card : cardMapper.selectByExample(example)) {
			appointmentExample.clear();
			appointmentExample.createCriteria().andCIdEqualTo(card.getcId());
			count += appointmentMapper.countByExample(appointmentExample);
		}
		return count;
	}

}
