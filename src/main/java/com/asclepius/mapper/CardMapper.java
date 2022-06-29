package com.asclepius.mapper;

import com.asclepius.pojo.Card;
import com.asclepius.pojo.CardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardMapper {
    long countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(Card row);

    int insertSelective(Card row);

    List<Card> selectByExampleWithRowbounds(CardExample example, RowBounds rowBounds);

    List<Card> selectByExample(CardExample example);

    Card selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("row") Card row, @Param("example") CardExample example);

    int updateByExample(@Param("row") Card row, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(Card row);

    int updateByPrimaryKey(Card row);
}