package com.asclepius.controller;

import com.asclepius.dto.ResultDTO;
import com.asclepius.dto.DoctorScheduleDTO;
import com.asclepius.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author sny
 * @CreateTime 2022-07-01  18:10
 * @Description ScheduleController
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {

	@Resource
	ScheduleService scheduleService;

	@GetMapping("/doctor/{dId}/{docId}")
	public ResultDTO getDoctorSchedule(@PathVariable("dId") Integer dId, @PathVariable("docId") Integer docId) {
		ResultDTO resultDTO = new ResultDTO();
		DoctorScheduleDTO doctorSchedule = scheduleService.getScheduleByDocId(docId,dId);
		if (doctorSchedule.getTimes().size() == 0) {
			resultDTO.setMessage("该医生最近无排班");
		}
		resultDTO.setData(doctorSchedule);
		return resultDTO;
	}

	@GetMapping("/department/{dId}")
	public ResultDTO getDepartmentSchedule(@PathVariable Integer dId) {
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setData(scheduleService.getDepartmentSchedule(dId));
		return resultDTO;
	}
}
