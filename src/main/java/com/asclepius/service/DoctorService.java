package com.asclepius.service;

import com.asclepius.dto.DoctorDTO;
import com.asclepius.mapper.DoctorMapper;
import com.asclepius.pojo.DoctorExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author sny
 * @CreateTime 2022-07-01  15:42
 * @Description TODO
 * @Version 1.0
 */
@Service
public class DoctorService {
    @Resource
    DoctorMapper doctorMapper;

    public List<DoctorDTO> getDoctorsByDId(int dId) {
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andDIdEqualTo(dId);
        return doctorMapper.selectByExample(doctorExample).stream().map((o1) -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(o1, doctorDTO);
            return doctorDTO;
        }).collect(Collectors.toList());
    }
}
