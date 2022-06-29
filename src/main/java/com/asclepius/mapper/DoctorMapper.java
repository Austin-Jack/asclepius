package com.asclepius.mapper;

import com.asclepius.pojo.Doctor;
import com.asclepius.pojo.DoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DoctorMapper {
    long countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer docId);

    int insert(Doctor row);

    int insertSelective(Doctor row);

    List<Doctor> selectByExampleWithRowbounds(DoctorExample example, RowBounds rowBounds);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Integer docId);

    int updateByExampleSelective(@Param("row") Doctor row, @Param("example") DoctorExample example);

    int updateByExample(@Param("row") Doctor row, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor row);

    int updateByPrimaryKey(Doctor row);
}