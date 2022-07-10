package com.july.cloud.framework.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.july.cloud.mybatisplus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单权限表
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenuEntity extends BaseEntity{
    /**
     * 菜单名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 菜单权限标识
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 前端URL
     */
    @TableField(value = "path")
    private String path;

    /**
     * 父菜单ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序值
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

    /**
     * 0-开启，1- 关闭
     */
    @TableField(value = "keep_alive")
    private String keepAlive;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    @TableField(value = "type")
    private String type;
}