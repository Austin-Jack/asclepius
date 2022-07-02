package com.asclepius.service;

import com.asclepius.common.Lua;
import com.asclepius.dto.AppointmentDTO;
import com.asclepius.mapper.AppointmentMapper;
import com.asclepius.mapper.ScheduleMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

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
    ScheduleMapper scheduleMapper;

    @Resource
    RedisTemplate<String, Integer> redisTemplate;

    public boolean addAppointment(AppointmentDTO appointmentDTO){
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptText(Lua.SECOND_KILL);
        int res = Integer.parseInt(String.valueOf(redisTemplate.execute(redisScript, Arrays.asList(String.valueOf(appointmentDTO.getcId()), String.valueOf(appointmentDTO.getsId())), (Object) null)));
        if (res >= 0){
            
        }
        return res < 0;
    }

}
