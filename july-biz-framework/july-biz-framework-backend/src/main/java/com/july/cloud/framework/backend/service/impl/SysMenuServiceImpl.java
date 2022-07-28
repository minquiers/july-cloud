package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.core.utils.CollectionUtils;
import com.july.cloud.framework.backend.convert.SysMenuConvert;
import com.july.cloud.framework.backend.dto.SysMenuDTO;
import com.july.cloud.framework.backend.entity.SysMenuEntity;
import com.july.cloud.framework.backend.entity.SysRoleMenuEntity;
import com.july.cloud.framework.backend.mapper.SysMenuMapper;
import com.july.cloud.framework.backend.service.ISysMenuService;
import com.july.cloud.framework.backend.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Minquiers
 * @description 针对表【sys_menu(菜单权限表)】的数据库操作Service实现
 * @createDate 2022-07-10 19:09:51
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity>
        implements ISysMenuService {

    @Autowired
    private SysMenuConvert sysMenuConvert;

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    @Override
    public String insertMenu(SysMenuDTO sysMenuDTO) {
        SysMenuEntity sysMenuEntity = sysMenuConvert.dtoToEntity(sysMenuDTO);
        baseMapper.insert(sysMenuEntity);
        return sysMenuEntity.getId();
    }

    @Override
    public String updateMenu(SysMenuDTO sysMenuDTO) {
        SysMenuEntity dbEntity = baseMapper.selectById(sysMenuDTO.getId());
        sysMenuConvert.dtoUpdateEntity(sysMenuDTO, dbEntity);
        baseMapper.updateById(dbEntity);
        return dbEntity.getId();
    }

    @Override
    public List<SysMenuEntity> findByRoles(List<String> roleIds) {
        LambdaQueryWrapper<SysRoleMenuEntity> roleMenuQuery = new LambdaQueryWrapper<>();
        roleMenuQuery.in(SysRoleMenuEntity::getRoleId, roleIds);
        List<SysRoleMenuEntity> roleMenuEntities = sysRoleMenuService.list(roleMenuQuery);
        if (CollectionUtils.isNotEmpty(roleMenuEntities)) {
            LambdaQueryWrapper<SysMenuEntity> roleQuery = new LambdaQueryWrapper<>();
            roleQuery.in(SysMenuEntity::getId, roleMenuEntities.stream().map(SysRoleMenuEntity::getRoleId).distinct().collect(Collectors.toList()));
            return list(roleQuery);
        }
        return null;
    }
}
