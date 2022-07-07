package com.asclepius.controller;

import com.asclepius.common.ResponseCode;
import com.asclepius.dto.AppointmentDTO;
import com.asclepius.dto.ResultDTO;
import com.asclepius.pojo.AppointmentExt;
import com.asclepius.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sny
 * @CreateTime 2022-07-01  19:32
 * @Description TODO
 * @Version 1.0
 */
@RequestMapping("/api/private")
@RestController
public class AppointmentController {

    @Resource
    AppointmentService appointmentService;

    @PostMapping("/appointment/add")
    public ResultDTO addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        ResultDTO resultDTO = new ResultDTO();
        int res = appointmentService.addAppointment(appointmentDTO);
        if (res == -1) {
            resultDTO.setCode(ResponseCode.NOT_FOUND);
            resultDTO.setMessage("预约已满");
        } else if (res == -2) {
            resultDTO.setData(ResponseCode.NOT_FOUND);
            resultDTO.setMessage("请不要重复预约");
        }
        return resultDTO;
    }

    @GetMapping("/user/aplist/{uId}")
    public ResultDTO getAppointmentByUId(@PathVariable(name = "uId") Integer uId) {
        ResultDTO resultDTO = new ResultDTO();
        List<AppointmentExt> appointmentExts = appointmentService.selectAppointmentByUId(uId);
        resultDTO.setData(appointmentExts);
        return resultDTO;
    }
}
