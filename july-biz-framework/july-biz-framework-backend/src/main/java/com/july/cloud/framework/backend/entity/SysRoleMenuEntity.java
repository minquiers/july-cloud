package com.july.cloud.framework.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.july.cloud.mybatisplus.base.BaseNoIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色菜单表
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenuEntity extends BaseNoIdEntity {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单id
     */
    private String menuId;
}