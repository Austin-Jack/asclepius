package com.asclepius.service;

import com.asclepius.dto.ClinicDTO;
import com.asclepius.dto.DepartmentDTO;
import com.asclepius.mapper.ClinicMapper;
import com.asclepius.mapper.DepartmentMapper;
import com.asclepius.pojo.Clinic;
import com.asclepius.pojo.ClinicExample;
import com.asclepius.pojo.Department;
import com.asclepius.pojo.DepartmentExample;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DepartmentService
 *
 * @author luolinyuan
 * @date 2022/7/3
 **/
@Service
public class DepartmentService {
	@Resource
	DepartmentMapper departmentMapper;

	@Resource
	ClinicMapper clinicMapper;

	@Cacheable(value = "department", key = "#level", condition = "#level between {0,2}")
	public List<ClinicDTO> getAllByLevel(Integer level) {
		List<ClinicDTO> result = new ArrayList<>();
		ClinicExample clinicExample = new ClinicExample();
		clinicExample.createCriteria().andCliLevelEqualTo(level);
		List<Clinic> clinics = clinicMapper.selectByExample(clinicExample);
		DepartmentExample example = new DepartmentExample();
		for (Clinic clinic : clinics) {
			ClinicDTO clinicDTO = new ClinicDTO();
			clinicDTO.setCliName(clinic.getCliName());
			example.clear();
			example.createCriteria().andCliIdEqualTo(clinic.getCliId());
			List<Department> departments = departmentMapper.selectByExample(example);
			List<DepartmentDTO> departmentDTOS = departments.stream().map(department -> {
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setName(department.getdName());
				departmentDTO.setdId(department.getdId());
				return departmentDTO;
			}).collect(Collectors.toList());

			clinicDTO.setDepartments(departmentDTOS);
			result.add(clinicDTO);
		}
		return result;
	}
}
