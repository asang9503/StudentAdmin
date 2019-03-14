package com.yyx.studentad.service.impl;

import com.yyx.studentad.constant.ConstantForAllPage;
import com.yyx.studentad.mapper.SchoolPerMapper;
import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.pojo.SchoolPer;
import com.yyx.studentad.Util.ResultUtil;
import com.yyx.studentad.service.SchoolPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    @Autowired
    private ConstantForAllPage constant;
    @Autowired
    private Map<String, Object> map;

    @Override
    public ResultBean registerIsSuccess(SchoolPer per) {
        if (per == null) {
            resultBean = resultUtil.ErrorReturn("输入不能为空");
        } else if (perMapper.selectByUsername(per.getPerUsername()) > 0) {
            resultBean = resultUtil.ErrorReturn("该账号已存在");
        } else {
            resultBean = resultUtil.RightReturn("注册成功");
        }
        return resultBean;
    }

    @Override
    public ResultBean login(SchoolPer per) {
        if (per == null) {
            resultBean =  resultUtil.ErrorReturn("账号或者密码不能为空！");
        } else if (perMapper.selectByUsernameAndPassword(per) == null) {
            resultBean =  resultUtil.ErrorReturn("账号或者密码错误！");
        } else {
            resultBean =  new ResultBean("登陆成功！", constant.SUCCESS, perMapper.selectByUsernameAndPassword(per));
        }
        return resultBean;
    }
}
