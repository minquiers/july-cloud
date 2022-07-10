package com.july.cloud.framework.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.framework.backend.dto.SysMenuDTO;
import com.july.cloud.framework.backend.entity.SysMenuEntity;

/**
* @author Minquiers
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service
* @createDate 2022-07-10 19:09:51
*/
public interface ISysMenuService extends IService<SysMenuEntity> {

    /**
     * 保存菜单
     * @param sysMenuDTO
     * @return
     */
    String insertMenu(SysMenuDTO sysMenuDTO);

    /**
     * 更新菜单
     * @param sysMenuDTO
     * @return
     */
    String updateMenu(SysMenuDTO sysMenuDTO);
}
