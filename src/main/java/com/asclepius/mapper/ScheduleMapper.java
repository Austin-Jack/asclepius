package com.asclepius.mapper;

import com.asclepius.pojo.Schedule;
import com.asclepius.pojo.ScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ScheduleMapper {
    long countByExample(ScheduleExample example);

    int deleteByExample(ScheduleExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(Schedule row);

    int insertSelective(Schedule row);

    List<Schedule> selectByExampleWithRowbounds(ScheduleExample example, RowBounds rowBounds);

    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("row") Schedule row, @Param("example") ScheduleExample example);

    int updateByExample(@Param("row") Schedule row, @Param("example") ScheduleExample example);

    int updateByPrimaryKeySelective(Schedule row);

    int updateByPrimaryKey(Schedule row);
}