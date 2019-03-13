package com.yyx.studentad.service;


import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.pojo.SchoolPer;

/**
 * 阿桑
 * 2019/3/12
 */

public interface SchoolPerService {

    ResultBean registerIsSuccess(SchoolPer per);

    ResultBean login(SchoolPer per);
}
