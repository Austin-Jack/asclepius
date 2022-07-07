package com.asclepius.mapper;

import com.asclepius.dto.AppointmentExtDTO;

import java.util.List;

public interface AppointmentMapperExt {
    List<AppointmentExtDTO> selectAppointmentByUId(Integer uId);

}
