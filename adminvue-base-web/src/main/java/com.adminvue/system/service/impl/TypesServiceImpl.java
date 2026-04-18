package com.adminvue.system.service.impl;


import com.adminvue.handler.BusinessException;
import com.adminvue.response.ResultCode;
import com.adminvue.system.entity.Types;
import com.adminvue.system.mapper.TypesMapper;
import com.adminvue.system.service.TypesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl extends ServiceImpl<TypesMapper, Types> implements TypesService {

    @Autowired
    private TypesMapper typesMapper;


    @Override
    public IPage<Types> findTypesPage(Page<Types> page, QueryWrapper<Types> wrapper) {
        return this.baseMapper.findTypesPage(page,wrapper);
    }

    @Override
    public void updateTypes(Types types) {
       this.baseMapper.updateById(types);
    }

    @Override
    public List<Types> findTypesByTname(String tname) {
        return typesMapper.findTypesByTname(tname);
    }

    @Override
    public void deleteTypes(Integer id) {
        this.baseMapper.deleteById(id);
    }

    @Override
    public List<Types> getTypes() {
        return typesMapper.getTypes();
    }

    @Override
    public void addTypes(Types types) {
        String username = types.getTname();
        QueryWrapper<Types> wrapper = new QueryWrapper<>();
        wrapper.eq("tname",username);
        Integer count = this.baseMapper.selectCount(wrapper);
        if(count!=0){
            throw new BusinessException(ResultCode.USER_ACCOUNT_ALREADY_EXIST.getCode(),
                    ResultCode.USER_ACCOUNT_ALREADY_EXIST.getMessage());
        }
        this.baseMapper.insert(types);
    }


}
