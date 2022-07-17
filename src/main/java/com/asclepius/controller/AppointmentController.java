package com.asclepius.controller;

import com.asclepius.common.ResponseCode;
import com.asclepius.dto.AppointmentDTO;
import com.asclepius.dto.ResultDTO;
import com.asclepius.dto.AppointmentExtDTO;
import com.asclepius.service.AppointmentService;
import com.asclepius.service.CardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sny
 * @CreateTime 2022-07-01  19:32
 * @Description TODO
 * @Version 1.0
 */
@RequestMapping("/api/private/user")
@RestController
public class AppointmentController {

	@Resource
	AppointmentService appointmentService;

	@Resource
	CardService cardService;

	private static final int PAGE_SIZE = 3;

	@PostMapping("/appointment/add")
	public ResultDTO addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		ResultDTO resultDTO = new ResultDTO();
		long res = appointmentService.addAppointment(appointmentDTO);
		if (res == -1) {
			resultDTO.setCode(ResponseCode.NOT_FOUND);
			resultDTO.setMessage("预约已满");
		} else if (res == -2) {
			resultDTO.setCode(ResponseCode.UNPROCESSABLE_ENTITY);
			resultDTO.setMessage("请不要重复预约");
		}
		return resultDTO;
	}

	@GetMapping("/aplist/{uId}/{pageNum}")
	public ResultDTO getAppointmentByUId(@PathVariable(name = "uId") Integer uId,
	                                     @PathVariable(name = "pageNum") Integer currPage) {
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setMessage(String.valueOf(appointmentService.selectAppointmentCountByUID(uId)));
		List<AppointmentExtDTO> appointmentExtDTOS = appointmentService.selectAppointmentByUId(uId,
				(currPage - 1) * PAGE_SIZE);
		resultDTO.setData(appointmentExtDTOS);
		return resultDTO;
	}

	@DeleteMapping("/cancel/{sId}/{cId}/{pageNum}")
	public ResultDTO deleteAppointment(@PathVariable(name = "sId") Integer sId,
	                                   @PathVariable(name = "cId") Integer cId,
	                                   @PathVariable(name = "pageNum") Integer curPage) {
		ResultDTO resultDTO = new ResultDTO();
		if (!appointmentService.cancelAppointment(sId, cId)) {
			resultDTO.setCode(ResponseCode.NOT_FOUND);
			resultDTO.setMessage("取消失败");
		}
		resultDTO.setData(appointmentService.selectAppointmentByUId(cardService.queryUIdByCId(cId),
				(curPage - 1) * PAGE_SIZE));
		return resultDTO;
	}
}
