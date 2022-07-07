package com.asclepius.service;

import com.asclepius.common.Lua;
import com.asclepius.dto.AppointmentDTO;
import com.asclepius.mapper.AppointmentMapper;
import com.asclepius.mapper.AppointmentMapperExt;
import com.asclepius.pojo.Appointment;
import com.asclepius.pojo.AppointmentExample;
import com.asclepius.pojo.AppointmentExt;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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

    public int addAppointment(AppointmentDTO appointmentDTO) {
        DefaultRedisScript<List> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(List.class);
        redisScript.setScriptText(Lua.SECOND_KILL);
        List<Long> res = redisTemplate.execute(redisScript, Arrays.asList(String.valueOf(appointmentDTO.getcId()), "sId_" + appointmentDTO.getsId()), (Object) null);
        Long remain = res.get(0);
        if (remain >= 0) {
            Appointment appointment = new Appointment();
            BeanUtils.copyProperties(appointmentDTO, appointment);
            appointment.setApStatus(0);
            appointment.setApNum(Integer.parseInt(String.valueOf(res.get(1))));
            appointmentMapper.insert(appointment);
        }
        return Integer.parseInt(String.valueOf(remain));
    }

    public boolean cancelAppointment(Integer sId, Integer cId) {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptText(Lua.CANCEL);
        int res = Integer.parseInt(String.valueOf(redisTemplate.execute(redisScript, Arrays.asList(String.valueOf(cId), "sId_" + sId), (Object) null)));
        if (res == 1) {
            AppointmentExample appointmentExample1 = new AppointmentExample();
            appointmentExample1.createCriteria().andSIdEqualTo(sId).andCIdEqualTo(cId).andApStatusEqualTo(0);
            Appointment appointment = appointmentMapper.selectByExample(appointmentExample1).get(0);
            appointment.setApStatus(3);
            AppointmentExample appointmentExample2 = new AppointmentExample();
            appointmentExample2.createCriteria().andSIdEqualTo(sId).andCIdEqualTo(cId);
            appointment.setApId(null);
            appointmentMapper.updateByExampleSelective(appointment, appointmentExample2);
        }
        return res == 1;
    }

    public List<AppointmentExt> selectAppointmentByUId(Integer uId) {
        return appointmentMapperExt.selectAppointmentByUId(uId);
    }

}
