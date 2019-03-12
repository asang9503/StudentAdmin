package com.yyx.studentad.service.impl;

import com.yyx.studentad.mapper.SchoolPerMapper;
import com.yyx.studentad.pojo.SchoolPer;
import com.yyx.studentad.service.SchoolPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 阿桑
 * 2019/3/12
 */
@Service
public class SchoolPerServiceImpl implements SchoolPerService {

    @Autowired
    private SchoolPerMapper perMapper;

    @Override
    public boolean RegistIsSuccess(SchoolPer per) {
        return per == null ? false : perMapper.insert(per) > 0;
    }
}
