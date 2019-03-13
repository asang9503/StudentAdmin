package com.yyx.studentad.resultbean;

import org.springframework.stereotype.Component;

/**
 * 阿桑
 * 2019/3/13
 */
@Component
public class ResultUtil {

    public ResultBean RightReturn(String msg) {
        return new ResultBean(msg, ResultConstant.SUCCESS,null);
    }
    public ResultBean ErrorReturn(String msg) {
        return new ResultBean(msg,ResultConstant.ERROR,null);
    }
}
