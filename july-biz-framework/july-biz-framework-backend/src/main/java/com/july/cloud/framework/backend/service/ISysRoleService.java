package com.july.cloud.framework.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.framework.backend.dto.SysRoleDTO;
import com.july.cloud.framework.backend.entity.SysRoleEntity;
import com.july.cloud.framework.backend.vo.SysRoleVO;

/**
* @author Minquiers
* @description 针对表【sys_role(系统角色表)】的数据库操作Service
* @createDate 2022-07-10 19:09:48
*/
public interface ISysRoleService extends IService<SysRoleEntity> {

    /**
     * 插入角色
     * @param sysRoleDTO
     * @return
     */
    String insertRole(SysRoleDTO sysRoleDTO);

    /**
     * 更新角色
     * @param sysRoleDTO
     * @return
     */
    String updateRole(SysRoleDTO sysRoleDTO);

    /**
     * 分页查询
     * @param page
     * @param roleDTO
     * @return
     */
    IPage<SysRoleVO> get(Page page, SysRoleDTO roleDTO);
}
