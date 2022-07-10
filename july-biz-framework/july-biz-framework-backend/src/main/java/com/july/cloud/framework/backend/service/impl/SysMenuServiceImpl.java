package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.framework.backend.convert.SysMenuConvert;
import com.july.cloud.framework.backend.dto.SysMenuDTO;
import com.july.cloud.framework.backend.entity.SysMenuEntity;
import com.july.cloud.framework.backend.mapper.SysMenuMapper;
import com.july.cloud.framework.backend.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public String insertMenu(SysMenuDTO sysMenuDTO) {
        SysMenuEntity sysMenuEntity = sysMenuConvert.dtoToEntity(sysMenuDTO);
        baseMapper.insert(sysMenuEntity);
        return sysMenuEntity.getId();
    }

    @Override
    public String updateMenu(SysMenuDTO sysMenuDTO) {
        SysMenuEntity dbEntity = baseMapper.selectById(sysMenuDTO.getId());
        sysMenuConvert.dtoUpdateEntity(sysMenuDTO , dbEntity);
        baseMapper.updateById(dbEntity);
        return dbEntity.getId();
    }
}
