package com.adminvue.system.mapper;

import com.adminvue.system.entity.Applys;
import com.adminvue.system.entity.Resumes;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplysMapper extends BaseMapper<Applys> {

    IPage<Applys> findApplysPage(Page<Applys> page, @Param(Constants.WRAPPER) QueryWrapper<Applys> wrapper);
}
