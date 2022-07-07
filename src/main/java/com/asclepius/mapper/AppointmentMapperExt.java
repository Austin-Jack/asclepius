package com.asclepius.mapper;

import com.asclepius.pojo.AppointmentExt;

import java.util.List;

public interface AppointmentMapperExt {
    List<AppointmentExt> selectAppointmentByUId(Integer uId);
}
