package com.july.cloud.framework.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.july.cloud.mybatisplus.base.BaseNoIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色表
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRoleEntity extends BaseNoIdEntity {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;
}