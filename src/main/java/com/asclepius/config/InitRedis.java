package com.asclepius.config;

import com.asclepius.mapper.ScheduleMapper;
import com.asclepius.pojo.Schedule;
import com.asclepius.pojo.ScheduleExample;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

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
    RedisTemplate<String, Integer> redisTemplate;

    @PostConstruct // 构造函数之后执行
    public void init() {

        initRedis();

    }

    private void initRedis() {
        ScheduleExample scheduleExample = new ScheduleExample();
        List<Schedule> schedules = scheduleMapper.selectByExample(scheduleExample);
        for (Schedule schedule : schedules) {
            redisTemplate.opsForValue().set("sId_" + schedule.getsId(), schedule.getNum());
            redisTemplate.opsForValue().set("sId_origin_" + schedule.getsId(), schedule.getNum());
        }
    }
}
