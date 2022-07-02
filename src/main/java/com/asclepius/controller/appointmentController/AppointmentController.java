package com.asclepius.controller.appointmentController;

import com.asclepius.dto.AppointmentDTO;
import com.asclepius.dto.ResultDTO;
import com.asclepius.service.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public ResultDTO addAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return new ResultDTO();
    }
}
