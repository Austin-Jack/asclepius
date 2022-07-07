package com.asclepius.service;

import cn.hutool.core.lang.hash.Hash;
import com.asclepius.dto.DoctorDTO;
import com.asclepius.mapper.DepartmentMapperExt;
import com.asclepius.mapper.DoctorMapper;
import com.asclepius.pojo.DoctorExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author sny
 * @CreateTime 2022-07-01  15:42
 * @Description TODO
 * @Version 1.0
 */
@Service
public class DoctorService {
	private static final int DOCTORS_PAGE_SIZE = 8;

	@Resource
	DoctorMapper doctorMapper;

	@Resource
	DepartmentMapperExt departmentMapperExt;


	public int getDepartmentDoctorNum(int dId) {
		DoctorExample doctorExample = new DoctorExample();
		doctorExample.createCriteria().andDIdEqualTo(dId);
		return (int) doctorMapper.countByExample(doctorExample);
	}

	public List<DoctorDTO> getDoctorsByDId(int dId, int currPage) {
		return departmentMapperExt.selectDoctorsByDid(dId, (currPage - 1) * DOCTORS_PAGE_SIZE);
	}
}
