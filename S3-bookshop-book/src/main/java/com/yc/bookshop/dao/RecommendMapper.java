package com.yc.bookshop.dao;

import com.yc.bookshop.bean.Recommend;
import com.yc.bookshop.bean.RecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {
    long countByExample(RecommendExample example);

    int deleteByExample(RecommendExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendExample example);

    Recommend selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}