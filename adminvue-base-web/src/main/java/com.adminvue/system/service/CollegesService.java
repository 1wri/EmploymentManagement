package com.adminvue.system.service;

import com.adminvue.system.entity.Colleges;
import com.adminvue.system.entity.Companys;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CollegesService extends IService<Colleges> {

    IPage<Colleges> findCollegesPage(Page<Colleges> page, QueryWrapper<Colleges> wrapper);
    void addColleges(Colleges colleges);
    List<Colleges> findCollegesByCbianhao(String cbianhao);
    List<Colleges> findCollegesByCname(String cname);
    void updateColleges(Colleges colleges);
    void deleteColleges(Integer id);
    List<Colleges> getColleges();
}
