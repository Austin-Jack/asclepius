package com.asclepius.mapper;

import com.asclepius.dto.AppointmentExtDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentMapperExt {
	List<AppointmentExtDTO> selectAppointmentByUIdPage(@Param("uId") Integer uId, @Param("offset") Integer currPage);
}
