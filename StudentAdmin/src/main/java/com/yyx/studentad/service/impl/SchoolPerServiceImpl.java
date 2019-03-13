package com.yyx.studentad.service.impl;

import com.yyx.studentad.resultbean.ResultConstant;
import com.yyx.studentad.mapper.SchoolPerMapper;
import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.pojo.SchoolPer;
import com.yyx.studentad.resultbean.ResultUtil;
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
    @Autowired
    private ResultUtil resultUtil;
    @Autowired
    private ResultBean resultBean;

    @Override
    public ResultBean registerIsSuccess(SchoolPer per) {
        resultBean = per == null ?
                resultUtil.ErrorReturn("输入不能为空") : perMapper.selectByUsername(per.getPerUsername()) > 0 ?
                resultUtil.ErrorReturn("该账号已存在") : resultUtil.RightReturn("注册成功");
        return resultBean;
    }

    @Override
    public ResultBean login(SchoolPer per) {
        return per == null ? resultUtil.ErrorReturn("账号或者密码不能为空！") : perMapper.selectByUsernameAndPassword(per) == null ?
                resultUtil.ErrorReturn("账号或者密码错误！") :
                new ResultBean("登陆成功！", ResultConstant.SUCCESS, perMapper.selectByUsernameAndPassword(per));
    }
}
