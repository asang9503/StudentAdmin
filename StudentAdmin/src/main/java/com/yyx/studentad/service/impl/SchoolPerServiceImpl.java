package com.yyx.studentad.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yyx.studentad.Util.JedisUtil;
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
    private Map<String, Object> map;
    @Autowired
    private JedisUtil jedisUtil;

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
            resultBean = resultUtil.ErrorReturn("账号或者密码错误！");
        } else {
            per = perMapper.selectByUsernameAndPassword(per);
            String key = ConstantForAllPage.TOKEN + per.getPerUsername();
            String value1 = JSONObject.toJSONString(per);
            jedisUtil.saveStringValue(key, value1);
            resultBean = new ResultBean("登陆成功！", ConstantForAllPage.SUCCESS, key);
        }
        return resultBean;
    }

    @Override
    public ResultBean isLogin(String token) {
        if (null != token && "" != token) {
            String value = jedisUtil.getStringValue(token);
            if (null == value || "" == value) {
                return resultUtil.ErrorReturn("请登录");
            } else {
                return resultUtil.RightReturn("已登录");
            }
        } else {
            return resultUtil.ErrorReturn("请登录");
        }
    }

    @Override
    public ResultBean exitLogin(String token) {
        if (null != token && "" != token) {
            return jedisUtil.removeString(token) ? resultUtil.RightReturn("登出成功") : resultUtil.ErrorReturn("登出失败!稍后再试!");
        } else {
            return resultUtil.ErrorReturn("登出失败!稍后再试!");
        }
    }
}
