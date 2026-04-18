package com.adminvue.system.service;

import com.adminvue.system.entity.Companys;
import com.adminvue.system.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CompanysService extends IService<Companys> {

    IPage<Companys> findCompanysPage(Page<Companys> page, QueryWrapper<Companys> wrapper);
    void addCompanys(Companys companys);
    void loginCompanys(String phone_number, String password);
    Companys findCompanysById(Integer id);
    Companys findCompanyByTel(String tel);
    List<Companys> findCompanysByTel(String tel);
    void updateCompanys(Companys companys);
    void deleteCompanys(Integer id);
}
