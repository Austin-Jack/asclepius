package com.asclepius.mapper;

import com.asclepius.pojo.Prescription;
import com.asclepius.pojo.PrescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PrescriptionMapper {
    long countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    int deleteByPrimaryKey(Integer preId);

    int insert(Prescription row);

    int insertSelective(Prescription row);

    List<Prescription> selectByExampleWithRowbounds(PrescriptionExample example, RowBounds rowBounds);

    List<Prescription> selectByExample(PrescriptionExample example);

    Prescription selectByPrimaryKey(Integer preId);

    int updateByExampleSelective(@Param("row") Prescription row, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("row") Prescription row, @Param("example") PrescriptionExample example);

    int updateByPrimaryKeySelective(Prescription row);

    int updateByPrimaryKey(Prescription row);
}