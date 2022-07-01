package com.asclepius.service;

import com.asclepius.dto.ScheduleDTO;
import com.asclepius.mapper.ScheduleMapper;
import com.asclepius.pojo.Schedule;
import com.asclepius.pojo.ScheduleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author sny
 * @CreateTime 2022-07-01  16:00
 * @Description TODO
 * @Version 1.0
 */
@Service
public class ScheduleService {
    @Resource
    ScheduleMapper scheduleMapper;

    public List<ScheduleDTO> getScheduleByDocIdWithBound(int docId, int scope) {
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria().andDocIdEqualTo(docId);
        List<Schedule> schedules = scheduleMapper.selectByExample(scheduleExample);
        Date now = new Date(System.currentTimeMillis());
        return schedules.stream().filter((o1) -> {
                    Date date = new Date(o1.getScStartTime());
                    long diff = date.getTime() - now.getTime();
                    return (diff / (1000 * 3600 * 24)) < scope * 7L;
                })
                .map((o1) -> {
                    ScheduleDTO scheduleDTO = new ScheduleDTO();
                    StringBuilder sb = new StringBuilder();
                    scheduleDTO.setsId(o1.getsId());
                    Date date = new Date(o1.getScStartTime());
                    sb.append(date.getYear() + 1900).append("-").append(date.getMonth() + 1).append("-").append(date.getDate());
                    switch (date.getDay()) {
                        case 0:
                            sb.append(" 周日");
                            break;
                        case 1:
                            sb.append(" 周一");
                            break;
                        case 2:
                            sb.append(" 周二");
                            break;
                        case 3:
                            sb.append(" 周三");
                            break;
                        case 4:
                            sb.append(" 周四");
                            break;
                        case 5:
                            sb.append(" 周五");
                            break;
                        case 6:
                            sb.append(" 周六");
                            break;
                    }
                    sb.append(date.getHours() < 12 ? " 上午" : " 下午");
                    scheduleDTO.setTime(sb.toString());
                    return scheduleDTO;
                }).collect(Collectors.toList());
    }
}
