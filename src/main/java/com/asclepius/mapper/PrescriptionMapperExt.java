package com.asclepius.mapper;

import com.asclepius.dto.PrescriptionDTO;

import java.util.List;

public interface PrescriptionMapperExt {
    List<PrescriptionDTO> selectPrescriptionByUId(Integer uId);
}
