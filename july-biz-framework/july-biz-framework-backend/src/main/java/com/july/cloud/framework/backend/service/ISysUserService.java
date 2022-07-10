package com.july.cloud.framework.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.framework.backend.dto.SysUserDTO;
import com.july.cloud.framework.backend.entity.SysUserEntity;

/**
* @author Minquiers
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2022-07-10 19:09:42
*/
public interface ISysUserService extends IService<SysUserEntity> {

    /**
     * 保存用户
     * @param userDTO
     * @return
     */
    String insertUser(SysUserDTO userDTO);

    /**
     * 更新用户
     * @param userDTO
     * @return
     */
    String updateUser(SysUserDTO userDTO);

}
