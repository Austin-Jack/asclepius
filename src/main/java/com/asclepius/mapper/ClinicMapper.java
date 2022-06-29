package com.asclepius.mapper;

import com.asclepius.pojo.Clinic;
import com.asclepius.pojo.ClinicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClinicMapper {
    long countByExample(ClinicExample example);

    int deleteByExample(ClinicExample example);

    int deleteByPrimaryKey(Integer cliId);

    int insert(Clinic row);

    int insertSelective(Clinic row);

    List<Clinic> selectByExampleWithRowbounds(ClinicExample example, RowBounds rowBounds);

    List<Clinic> selectByExample(ClinicExample example);

    Clinic selectByPrimaryKey(Integer cliId);

    int updateByExampleSelective(@Param("row") Clinic row, @Param("example") ClinicExample example);

    int updateByExample(@Param("row") Clinic row, @Param("example") ClinicExample example);

    int updateByPrimaryKeySelective(Clinic row);

    int updateByPrimaryKey(Clinic row);
}