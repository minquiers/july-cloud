package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.framework.backend.convert.SysRoleConvert;
import com.july.cloud.framework.backend.dto.SysRoleDTO;
import com.july.cloud.framework.backend.entity.SysRoleEntity;
import com.july.cloud.framework.backend.mapper.SysRoleMapper;
import com.july.cloud.framework.backend.service.ISysRoleService;
import com.july.cloud.framework.backend.vo.SysRoleVO;
import com.july.cloud.mybatisplus.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Minquiers
* @description 针对表【sys_role(系统角色表)】的数据库操作Service实现
* @createDate 2022-07-10 19:09:48
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity>
implements ISysRoleService {

    @Autowired
    private SysRoleConvert sysRoleConvert;

    @Override
    public String insertRole(SysRoleDTO sysRoleDTO) {
        SysRoleEntity sysRoleEntity = sysRoleConvert.dtoToEntity(sysRoleDTO);
        baseMapper.insert(sysRoleEntity);
        return sysRoleEntity.getId();
    }

    @Override
    public String updateRole(SysRoleDTO sysRoleDTO) {
        SysRoleEntity dbEntity = baseMapper.selectById(sysRoleDTO.getId());
        sysRoleConvert.dtoUpdateEntity(sysRoleDTO , dbEntity);
        baseMapper.updateById(dbEntity);
        return dbEntity.getId();
    }

    @Override
    public IPage<SysRoleVO> get(Page page, SysRoleDTO roleDTO) {
        IPage<SysRoleEntity> iPage = baseMapper.selectPage(page, Wrappers.query(roleDTO));
        return PageUtils.buildSuccessPageVo(iPage, sysRoleConvert.entitiesToVOs(iPage.getRecords()));
    }
}
