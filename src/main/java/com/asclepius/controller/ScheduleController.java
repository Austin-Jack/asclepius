package com.asclepius.controller;

import com.asclepius.dto.ResultDTO;
import com.asclepius.service.ScheduleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author sny
 * @CreateTime 2022-07-01  18:10
 * @Description TODO
 * @Version 1.0
 */

@RequestMapping
@RestController
public class ScheduleController {

	@Resource
	ScheduleService scheduleService;

	@PostMapping("/doctor/getSch")
	public ResultDTO getDoctorSchedule(@RequestBody Map<String, Integer> params) {
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setData(scheduleService.getScheduleByDocIdWithBound(params.get("docId"), params.get("scope")));
		return resultDTO;
	}
}
