package com.yc.bookshop.dao;

import com.yc.bookshop.bean.Show;
import com.yc.bookshop.bean.ShowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowMapper {
    long countByExample(ShowExample example);

    int deleteByExample(ShowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Show record);

    int insertSelective(Show record);

    List<Show> selectByExample(ShowExample example);

    Show selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Show record, @Param("example") ShowExample example);

    int updateByExample(@Param("record") Show record, @Param("example") ShowExample example);

    int updateByPrimaryKeySelective(Show record);

    int updateByPrimaryKey(Show record);
}