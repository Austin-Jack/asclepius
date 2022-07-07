package com.asclepius.service;

import com.asclepius.dto.PrescriptionDTO;
import com.asclepius.mapper.PrescriptionMapper;
import com.asclepius.mapper.PrescriptionMapperExt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sny
 * @CreateTime 2022-07-07  16:31
 * @Description TODO
 * @Version 1.0
 */
@Service
public class PrescriptionService {
    @Resource
    PrescriptionMapperExt prescriptionMapperExt;

    public List<PrescriptionDTO> selectPrescriptionByUId(Integer uId){
        return prescriptionMapperExt.selectPrescriptionByUId(uId);
    }
}
