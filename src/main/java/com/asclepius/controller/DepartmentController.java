package com.asclepius.controller;

import com.asclepius.dto.ClinicDTO;
import com.asclepius.dto.ResultDTO;
import com.asclepius.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * DepartmentController
 *
 * @author luolinyuan
 * @date 2022/7/3
 **/
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Resource
	DepartmentService departmentService;

	@GetMapping("/showAllByLevel/{level}")
	public ResultDTO showAll(@PathVariable Integer level) {
		List<ClinicDTO> allByLevel = departmentService.getAllByLevel(level);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setData(allByLevel);
		return resultDTO;
	}
}
