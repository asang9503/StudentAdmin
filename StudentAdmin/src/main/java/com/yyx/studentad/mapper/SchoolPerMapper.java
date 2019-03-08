package com.yyx.studentad.mapper;

import com.yyx.studentad.pojo.SchoolPer;

public interface SchoolPerMapper {
    int deleteByPrimaryKey(Integer perId);

    int insert(SchoolPer record);

    int insertSelective(SchoolPer record);

    SchoolPer selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(SchoolPer record);

    int updateByPrimaryKey(SchoolPer record);
}