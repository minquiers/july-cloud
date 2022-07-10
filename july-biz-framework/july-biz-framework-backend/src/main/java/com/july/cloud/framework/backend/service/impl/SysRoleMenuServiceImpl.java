package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.core.utils.CollectionUtils;
import com.july.cloud.framework.backend.dto.SysRoleMenuDTO;
import com.july.cloud.framework.backend.entity.SysRoleMenuEntity;
import com.july.cloud.framework.backend.mapper.SysRoleMenuMapper;
import com.july.cloud.framework.backend.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Minquiers
* @description 针对表【sys_role_menu(角色菜单表)】的数据库操作Service实现
* @createDate 2022-07-10 19:09:55
*/
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuEntity>
implements ISysRoleMenuService {

    @Transactional
    @Override
    public void saveRoleMenus(String roleId, List<String> menus) {
        //删除原来关系
        LambdaQueryWrapper<SysRoleMenuEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRoleMenuEntity::getRoleId , roleId);
        baseMapper.delete(queryWrapper);

        //保存最新关系
        if(CollectionUtils.isNotEmpty(menus)){
            List<SysRoleMenuEntity> rels = menus.stream().map(e->{
                SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
                sysRoleMenuEntity.setRoleId(roleId);
                sysRoleMenuEntity.setMenuId(e);
                return sysRoleMenuEntity;
            }).distinct().collect(Collectors.toList());
            saveBatch(rels);
        }

    }
}
