package com.asclepius.mapper;

import com.asclepius.dto.DoctorDTO;
import com.asclepius.dto.DoctorScheduleDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DepartmentMapperExt
 *
 * @author luolinyuan
 * @date 2022/7/5
 **/
public interface DepartmentMapperExt {
	DoctorScheduleDTO getCliByDid(Integer dId);

	List<String> getDepartmentSchedule(@Param("dId") Integer dId, @Param("start") Long start, @Param("end") Long end);

	List<DoctorDTO> selectDoctorsByDid(@Param("dId") Integer dId, @Param("currIndex") Integer currIndex);
}
