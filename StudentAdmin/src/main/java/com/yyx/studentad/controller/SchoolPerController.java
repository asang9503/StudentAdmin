package com.yyx.studentad.controller;

import com.yyx.studentad.pojo.SchoolPer;
import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.service.SchoolPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 阿桑
 * 2019/3/12
 */
@RestController
@RequestMapping("/do/user")
public class SchoolPerController {

    @Autowired
    private SchoolPerService perService;

    @PostMapping("/register")
    public ResultBean register(SchoolPer per) {
        return perService.registerIsSuccess(per);
    }

    @PostMapping("/login")
    public ResultBean login(SchoolPer per) {
        return perService.login(per);
    }
}
