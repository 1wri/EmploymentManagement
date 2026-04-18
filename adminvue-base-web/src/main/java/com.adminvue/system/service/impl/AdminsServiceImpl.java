package com.adminvue.system.service.impl;


import com.adminvue.handler.BusinessException;
import com.adminvue.response.ResultCode;
import com.adminvue.system.entity.Admins;
import com.adminvue.system.entity.User;
import com.adminvue.system.mapper.AdminsMapper;
import com.adminvue.system.service.AdminsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements AdminsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<Admins> findAdminsPage() {
        return this.baseMapper.findAdminsPage();
    }

    @Override
    public void loginUser(String utel, String password) {
        QueryWrapper<Admins> userWrapper = new QueryWrapper<>();
        userWrapper.eq("utel",utel);
        userWrapper.eq("upwd",password);
        Integer count = this.baseMapper.selectCount(userWrapper);
        if(count == 0){
            throw new BusinessException(ResultCode.USER_ACCOUNT_NOT_EXIST.getCode(),ResultCode.USER_ACCOUNT_NOT_EXIST.getMessage());
        }
    }

    @Override
    public List<Admins> findAdminByutel(String utel) {
        QueryWrapper<Admins> userWrapper = new QueryWrapper<>();
        userWrapper.eq("utel",utel);
        return this.baseMapper.selectList(userWrapper);
    }

    @Override
    public void updateAdmins(Admins admins) {
        this.baseMapper.updateById(admins);
    }
}
