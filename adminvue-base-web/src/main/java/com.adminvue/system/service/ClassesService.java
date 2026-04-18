package com.adminvue.system.service;

import com.adminvue.system.entity.Classes;
import com.adminvue.system.entity.Majors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ClassesService extends IService<Classes> {

    IPage<Classes> findClassesPage(Page<Classes> page, QueryWrapper<Classes> wrapper);
    void addClasses(Classes classes);
    List<Classes> findClassesByCtel(String ctel);
    List<Classes> findClassesByCname(String cname);
    void updateClasses(Classes classes);
    void deleteClasses(Integer id);
    List<Classes> getClasses();
}
