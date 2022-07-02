package com.asclepius.controller.doctor;

import com.asclepius.dto.ResultDTO;
import com.asclepius.service.DoctorService;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "/doctor", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {

    @Resource
    DoctorService doctorService;

    @GetMapping("/{dId}")
    public ResultDTO getDoctor(@PathVariable(name = "dId") Integer dId){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setData(doctorService.getDoctorsByDId(dId));
        return resultDTO;
    }

}
