package com.july.cloud.framework.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.july.cloud.mybatisplus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色表
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleEntity extends BaseEntity {
    /**
     * 
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 
     */
    @TableField(value = "role_code")
    private String roleCode;

    /**
     * 
     */
    @TableField(value = "role_desc")
    private String roleDesc;
}