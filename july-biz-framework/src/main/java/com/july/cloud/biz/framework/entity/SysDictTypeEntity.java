package com.july.cloud.biz.framework.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.july.cloud.mybatisplus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典类型表
 *
 * @TableName sys_dict_type
 */
@TableName(value = "sys_dict_type")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictTypeEntity extends BaseEntity {

    /**
     * 字典名称
     */
    @TableField(value = "dict_name")
    private String dictName;

    /**
     * 字典类型
     */
    @TableField(value = "dict_type")
    private String dictType;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
}