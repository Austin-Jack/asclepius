package com.asclepius.controller;

import com.asclepius.dto.ResultDTO;
import com.asclepius.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sny
 * @CreateTime 2022-07-01  15:38
 * @Description TODO
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {

	@Resource
	DoctorService doctorService;

	@GetMapping("/{dId}/{pageNum}")
	public ResultDTO getDoctor(@PathVariable(name = "dId") int dId,@PathVariable(name = "pageNum") int pageNum) {
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setMessage(String.valueOf(doctorService.getDepartmentDoctorNum(dId)));
		resultDTO.setData(doctorService.getDoctorsByDId(dId, pageNum));
		return resultDTO;
	}
}
