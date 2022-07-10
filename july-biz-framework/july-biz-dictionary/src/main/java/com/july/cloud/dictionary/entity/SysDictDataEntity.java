package com.july.cloud.dictionary.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.july.cloud.mybatisplus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典数据表
 *
 * @TableName sys_dict_data
 */
@TableName(value = "sys_dict_data")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictDataEntity extends BaseEntity {
    /**
     * 字典排序
     */
    @TableField(value = "dict_sort")
    private Integer dictSort;

    /**
     * 字典标签
     */
    @TableField(value = "dict_label")
    private String dictLabel;

    /**
     * 字典键值
     */
    @TableField(value = "dict_value")
    private String dictValue;

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