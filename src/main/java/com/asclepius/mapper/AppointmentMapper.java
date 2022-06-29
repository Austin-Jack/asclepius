package com.asclepius.mapper;

import com.asclepius.pojo.Appointment;
import com.asclepius.pojo.AppointmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AppointmentMapper {
    long countByExample(AppointmentExample example);

    int deleteByExample(AppointmentExample example);

    int deleteByPrimaryKey(Integer apId);

    int insert(Appointment row);

    int insertSelective(Appointment row);

    List<Appointment> selectByExampleWithRowbounds(AppointmentExample example, RowBounds rowBounds);

    List<Appointment> selectByExample(AppointmentExample example);

    Appointment selectByPrimaryKey(Integer apId);

    int updateByExampleSelective(@Param("row") Appointment row, @Param("example") AppointmentExample example);

    int updateByExample(@Param("row") Appointment row, @Param("example") AppointmentExample example);

    int updateByPrimaryKeySelective(Appointment row);

    int updateByPrimaryKey(Appointment row);
}