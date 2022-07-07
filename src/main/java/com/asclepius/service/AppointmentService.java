package com.asclepius.service;

import com.asclepius.common.Lua;
import com.asclepius.dto.AppointmentDTO;
import com.asclepius.mapper.AppointmentMapper;
import com.asclepius.mapper.AppointmentMapperExt;
import com.asclepius.pojo.Appointment;
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
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptText(Lua.SECOND_KILL);
        int res = Integer.parseInt(String.valueOf(redisTemplate.execute(redisScript, Arrays.asList(String.valueOf(appointmentDTO.getcId()), "sId_" + appointmentDTO.getsId()), (Object) null)));
        if (res >= 0) {
            Appointment appointment = new Appointment();
            BeanUtils.copyProperties(appointmentDTO, appointment);
            appointment.setApStatus(0);
            int origin = Integer.parseInt(String.valueOf(redisTemplate.opsForValue().get("sId_origin_" + appointmentDTO.getsId())));
            appointment.setApNum(origin - res);
            appointmentMapper.insert(appointment);
        }
        return res;
    }

    public List<AppointmentExt> selectAppointmentByUId(Integer uId) {
        return appointmentMapperExt.selectAppointmentByUId(uId);
    }

}
