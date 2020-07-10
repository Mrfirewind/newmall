package com.newmall.service;

import com.newmall.pojo.Stu;

/**
 * @author zhangweiqiang
 * @Description
 */
public interface StuService {
    Stu getStuInfo(int id);

    void saveStu();

    void updateStu(int id);

    void deleteStu(int id);
}
