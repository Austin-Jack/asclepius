package com.asclepius.controller;

import com.asclepius.dto.PrescriptionDTO;
import com.asclepius.dto.ResultDTO;
import com.asclepius.service.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sny
 * @CreateTime 2022-07-07  16:41
 * @Description TODO
 * @Version 1.0
 */
@RestController()
@RequestMapping("/api/private")
public class PrescriptionController {
    @Resource
    PrescriptionService prescriptionService;

    @GetMapping("/user/prescribe")
    public ResultDTO getPrescriptionByUId(@RequestParam(value = "uId") Integer uId) {
        ResultDTO resultDTO = new ResultDTO();
        List<PrescriptionDTO> prescriptionDTOS = prescriptionService.selectPrescriptionByUId(uId);
        resultDTO.setData(prescriptionDTOS);
        return resultDTO;
    }
}
