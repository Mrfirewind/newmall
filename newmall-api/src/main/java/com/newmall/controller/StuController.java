package com.newmall.controller;

import com.newmall.pojo.Stu;
import com.newmall.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangweiqiang
 * @Description
 */
@RestController
public class StuController {

    @Autowired
    private StuService stuService;

    @GetMapping("/getStu/{stuId}")
    public Stu getStuInfo(@PathVariable Integer stuId){
        return stuService.getStuInfo(stuId);
    }
}
