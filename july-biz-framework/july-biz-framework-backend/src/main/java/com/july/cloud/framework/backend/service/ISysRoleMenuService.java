package com.july.cloud.framework.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.framework.backend.entity.SysRoleMenuEntity;

import java.util.List;

/**
* @author Minquiers
* @description 针对表【sys_role_menu(角色菜单表)】的数据库操作Service
* @createDate 2022-07-10 19:09:55
*/
public interface ISysRoleMenuService extends IService<SysRoleMenuEntity> {

    /**
     * 保存角色菜单关系
     * @param roleId
     * @param menus
     */
    void saveRoleMenus(String roleId, List<String> menus);
}
