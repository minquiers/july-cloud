package com.july.cloud.framework.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.framework.backend.dto.SysUserDTO;
import com.july.cloud.framework.backend.entity.SysUserRoleEntity;

/**
* @author Minquiers
* @description 针对表【sys_user_role(用户角色表)】的数据库操作Service
* @createDate 2022-07-10 19:09:59
*/
public interface ISysUserRoleService extends IService<SysUserRoleEntity> {

    /**
     * 用户角色关联
     * @param userDTO
     */
    void userRoleRel(SysUserDTO userDTO);

}
